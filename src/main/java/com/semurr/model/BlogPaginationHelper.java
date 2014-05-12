package com.semurr.model;

/**
 * @author stephen
 * 
 *         Model for the pager helper program. Will hold the starting page
 *         number the end page number and the current page number for the news
 *         page
 * 
 */
public class BlogPaginationHelper {

	int	startPageNumber;
	int	endPageNumber;
	int	currentPageNumber;
	int	maxPageNumber;

	/**
	 * @return the maxPageNumber
	 */
	public int getMaxPageNumber() {
		return maxPageNumber;
	}

	/**
	 * @param maxPageNumber
	 *            the maxPageNumber to set
	 */
	public void setMaxPageNumber(int maxPageNumber) {
		this.maxPageNumber = maxPageNumber;
	}

	/**
	 * @return the startPageNumber
	 */
	public int getStartPageNumber() {
		return startPageNumber;
	}

	/**
	 * @param startPageNumber
	 *            the startPageNumber to set
	 */
	public void setStartPageNumber(int startPageNumber) {
		this.startPageNumber = startPageNumber;
	}

	/**
	 * @return the endPageNumber
	 */
	public int getEndPageNumber() {
		return endPageNumber;
	}

	/**
	 * @param endPageNumber
	 *            the endPageNumber to set
	 */
	public void setEndPageNumber(int endPageNumber) {
		this.endPageNumber = endPageNumber;
	}

	/**
	 * @return the currentPageNumber
	 */
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	/**
	 * @param currentPageNumber
	 *            the currentPageNumber to set
	 */
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
}
