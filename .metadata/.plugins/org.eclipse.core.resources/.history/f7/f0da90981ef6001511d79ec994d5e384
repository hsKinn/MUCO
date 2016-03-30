package com.ktds.muco.util.file;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MultipartHttpServletRequest {

	private HttpServletRequest request;
	private List<FileItem> items;
	private MultipartFile file;

	/**
	 * Multipart Http Servlet Request
	 * 
	 * @param request
	 */
	public MultipartHttpServletRequest(HttpServletRequest request) {
		this.request = request;

		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = request.getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");

		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * Get Parameter
	 * 
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		for (FileItem fileItem : items) {
			if (fileItem.getFieldName().equals(name)) {
				try {
					return fileItem.getString("UTF-8");
				} catch (UnsupportedEncodingException e) {
					return fileItem.getString();
				}
			}
		}
		return null;
	}

	/**
	 * Get Parameter Values
	 * 
	 * @param name
	 * @return
	 */
	public List<String> getParameterValues(String name) {
		List<String> values = new ArrayList<String>();

		for (FileItem fileItem : items) {
			if (fileItem.getFieldName().equals(name)) {
				try {
					values.add(fileItem.getString("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					values.add(fileItem.getString());
				}
			}
		}
		return values;
	}

	/**
	 * Get Session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return request.getSession();
	}

	/**
	 * Get Request Dispatcher
	 * 
	 * @param jspPage
	 * @return
	 */
	public RequestDispatcher getRequestDispatcher(String jspPage) {
		return request.getRequestDispatcher(jspPage);
	}

	/**
	 * Get File
	 * 
	 * @param name
	 * @return
	 */
	public MultipartFile getFile(String name) {
		file = new MultipartFile();

		for (FileItem fileItem : items) {
			if (fileItem.getFieldName().equals(name)) {
				file.setFileName(fileItem.getName());
				file.setFileSize(fileItem.getSize());
				file.setContentType(fileItem.getContentType());
				file.setFileItem(fileItem);

				return file;
			}
		}
		return null;
	}
}
