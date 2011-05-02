/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package uit.qabpss.util.dao.orm;

import uit.qabpss.util.OrderByComparator;
import uit.qabpss.util.log.Log;
import uit.qabpss.util.log.LogFactoryUtil;



/**
 * <a href="CustomSQLUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 *
 */
public class CustomSQLUtil {

	public static String get(String id) {
		return _instance._customSQL.get(id);
	}


	public static String[] keywords(String keywords) {
		return _instance._customSQL.keywords(keywords);
	}

	public static String[] keywords(String keywords, boolean lowerCase) {
		return _instance._customSQL.keywords(keywords, lowerCase);
	}

	public static String[] keywords(String[] keywordsArray) {
		return _instance._customSQL.keywords(keywordsArray);
	}

	public static String[] keywords(String[] keywordsArray, boolean lowerCase) {
		return _instance._customSQL.keywords(
			keywordsArray, lowerCase);
	}

	public static String replaceAndOperator(String sql, boolean andOperator) {
		return _instance._customSQL.replaceAndOperator(
			sql, andOperator);
	}

	public static String replaceIsNull(String sql) {
		return _instance._customSQL.replaceIsNull(sql);
	}

	public static String replaceKeywords(
		String sql, String field, String operator, boolean last,
		String[] values) {

		return _instance._customSQL.replaceKeywords(
			sql, field, operator, last, values);
	}

	public static String removeOrderBy(String sql) {
		return _instance._customSQL.removeOrderBy(sql);
	}

	public static String replaceOrderBy(String sql, OrderByComparator obc) {
		return _instance._customSQL.replaceOrderBy(sql, obc);
	}

	private CustomSQLUtil() {
		try {
			_customSQL = new CustomSQL();
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}
 /**
         *
         * @param fieldname
         * @param operator
         * @return Structure: (fieldname operator ? [$AND_OR_NULL_CHECK$])
         */
        public static String createOperatorForField(String fieldname,String operator){
            return _instance._customSQL.createOperatorForField(fieldname, operator);
        }
	private static Log _log = LogFactoryUtil.getLog(CustomSQLUtil.class);

	private static CustomSQLUtil _instance = new CustomSQLUtil();

	private CustomSQL _customSQL;
        public static String AND_OR_CONECTOR  =   "[$AND_OR_CONNECTOR$]";
        public static String AND_OR_NULL_CHECK  =   "[$AND_OR_NULL_CHECK$]";
}