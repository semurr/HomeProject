package com.semurr.helper;

import com.semurr.model.BlogPaginationHelper;

/**
 * @author stephen
 * 
 *         A Helper method for blogs, from a list size tells you how many you
 *         can displayer per page You are able to change the blogsPerPage value
 *         if youw ant to display more on the page
 * 
 */
public class blogHelper {

	private static int	blogPerPage	= 5;

	/**
	 * @return the blogPerPage
	 */
	public static int getBlogPerPage() {
		return blogPerPage;
	}

	/**
	 * @param blogPerPage
	 *            the blogPerPage to set
	 */
	public static void setBlogPerPage(int blogPerPage) {
		blogHelper.blogPerPage = blogPerPage;
	}

	/**
	 * A helper method to determine from a blog list, which blog to start with,
	 * which to end with
	 * 
	 * @param startPageNumber
	 *            The current page number request by the client
	 * @param blogListSize
	 *            the size of the blog list of all
	 * @return a BlogPagerHelper class that contains all the requried info
	 *         needed. If bad values are passed will return null.
	 */
	public static BlogPaginationHelper blogListLimitationHelper(int startPageNumber,
			int blogListSize) {

		BlogPaginationHelper BlogPagerHelper = new BlogPaginationHelper();
		
		BlogPagerHelper.setCurrentPageNumber(startPageNumber);

		// grab the starting number
		BlogPagerHelper.setStartPageNumber((blogPerPage * startPageNumber)
				- blogPerPage);
		BlogPagerHelper
				.setEndPageNumber(BlogPagerHelper.getStartPageNumber() + 5);

		// check if startPage is greater then blogSize return -1
		if (BlogPagerHelper.getStartPageNumber() > blogListSize) {
			return null;
		}

		// if the end number is greater then blog list return the size number
		if (BlogPagerHelper.getEndPageNumber() > blogListSize) {
			BlogPagerHelper.setEndPageNumber(blogListSize);
		}

		BlogPagerHelper.setMaxPageNumber(getMaxPaginationSize(blogListSize));

		return BlogPagerHelper;
	}

	/**
	 * @param blogListSize
	 *            The max list of the blog size
	 * @return the max number of pages availbe for the pager
	 */
	private static int getMaxPaginationSize(int blogListSize) {

		int maxPagerSizeLimit = blogListSize / blogPerPage;

		if (blogListSize % blogPerPage != 0) {
			maxPagerSizeLimit++;
		}

		return maxPagerSizeLimit;

	}

}
