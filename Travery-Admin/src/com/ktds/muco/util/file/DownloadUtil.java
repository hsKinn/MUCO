package com.ktds.muco.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadUtil {

	private String uploadPath;

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	private static DownloadUtil downloadUtil;

	private DownloadUtil() {
	}

	public static DownloadUtil getInstance(String filePath) {

		if (downloadUtil == null) {
			downloadUtil = new DownloadUtil();
		}

		downloadUtil.setUploadPath(filePath);

		return downloadUtil;
	}

	public void download(HttpServletRequest request, HttpServletResponse response, String realFileName,
			String displayFileName) throws UnsupportedEncodingException {

		File downloadFile = new File(this.getUploadPath() + File.separator + realFileName);

		response.setContentType("application/download; charset=utf-8");
		response.setContentLength((int) downloadFile.length());

		// 사용자의 브라우져 정보를 가져온다.
		String userAgent = request.getHeader("User-Agent");
		// 사용자의 브라우저가 MicroSoft Internet Explorer 인지 확인한다.
		boolean internetExplorer = userAgent.indexOf("MSIE") > -1;
		if (!internetExplorer) {
			internetExplorer = userAgent.indexOf("Gecko") > -1;
		}

		// 다운로드할 파일의 이름을 브라우져별로 가져온다.
		String fileName = new String(displayFileName.getBytes(), "UTF-8");
		if (internetExplorer) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		} else {
			// File의 이름을 UTF-8 타입에서 ISO-8859-1 타입으로 변경한다.
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		// 브라우져가 받을 파일의 이름을 response에 등록한다.
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		// 브라우져가 다운로드 받은 후 Binary 파일로 생성하라고 보낸다.
		response.setHeader("Content-Transfer-Encoding", "binary");

		FileInputStream fin = null;
		FileChannel inputChannel = null;
		WritableByteChannel outputChannel = null;

		try {
			fin = new FileInputStream(downloadFile);
			inputChannel = fin.getChannel();

			outputChannel = Channels.newChannel(response.getOutputStream());
			inputChannel.transferTo(0, fin.available(), outputChannel);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				if (outputChannel.isOpen())
					outputChannel.close();
			} catch (Exception e) {
			}
			try {
				if (inputChannel.isOpen())
					inputChannel.close();
			} catch (Exception e) {
			}
			try {
				if (fin != null)
					fin.close();
			} catch (Exception e) {
			}
		}
	}

}
