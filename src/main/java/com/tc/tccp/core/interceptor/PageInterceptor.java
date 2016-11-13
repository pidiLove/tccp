//package com.tc.tccp.core.interceptor; 
///** 
// * @author wangpei 
// * @version 
// *����ʱ�䣺2016��10��12�� ����10:48:48 
// * ��˵�� 
// */
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Properties;
//
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.executor.parameter.ParameterHandler;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.logging.Log;
//import org.apache.ibatis.logging.LogFactory;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
//import org.apache.ibatis.reflection.factory.ObjectFactory;
//import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
//import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
//import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.RowBounds;
//
//import com.tc.tccp.core.page.PageParameter;
//
// 
///**
// * 
//* @ClassName PageInterceptor
//* @Description ��ҳ������
//* @author fengshj
//* @date 2014��10��9��
// */
////args = {Connection.class}����ֻҪ���������Ӷ��Ƚ���������
//@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
//public class PageInterceptor implements Interceptor {
//    private static final Log logger = LogFactory.getLog(PageInterceptor.class);
//    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
//    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
//    private static String defaultDialect = "mysql"; // ���ݿ�����(Ĭ��Ϊmysql)
//    private static String defaultPageSqlId = ".*Page$"; // ��Ҫ���ص�ID(����ƥ��)
//    private static String dialect = ""; // ���ݿ�����(Ĭ��Ϊmysql)
//    private static String pageSqlId = ""; // ��Ҫ���ص�ID(����ƥ��)
//    private Properties properties;
//
//    public PageInterceptor() {
//		this.properties = null;
//	}
//    
//    @Override
//    public void setProperties(Properties properties) {
//		this.properties = properties;
//	}
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
//        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
//                DEFAULT_OBJECT_WRAPPER_FACTORY);
//        // ������������(����Ŀ������ܱ�������������أ��Ӷ��γɶ�δ���ͨ�����������ѭ�����Է������ԭʼ�ĵ�Ŀ����)
//        while (metaStatementHandler.hasGetter("h")) {
//            Object object = metaStatementHandler.getValue("h");
//            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
//        }
//        // �������һ����������Ŀ����
//        while (metaStatementHandler.hasGetter("target")) {
//            Object object = metaStatementHandler.getValue("target");
//            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
//        }
//        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
//        /*�˴�ȡdialectȡ�ľ���configuration.xml���property,dialect = configuration.getVariables().getProperty("dialect");
//         * ��ȡ����configuration.xml������ֶ����ʹ�ã����ַ�������ֱ��ȡ����ʵ����this.properties
//         * <properties>
//				<property name="dialect" value="mysql"/>
//				<property name="pageSqlId" value=".*Page$" />
//			</properties> 
//         * */
//        //dialect = configuration.getVariables().getProperty("dialect");
//        
//        /*
//         * ����ȡ���������д����ʹ�ã���������ȡ����һ��Ҫ�Ƚ�this.propertiesʵ����
//         * <plugin interceptor="my.comm.interceptor.PageInterceptor">
//				<property name="dialect" value="mysql"/>
//				<property name="pageSqlId" value=".*Page$" />
//		  </plugin>
//         */
//        dialect = this.properties.getProperty("dialect");
//        if (null == dialect || "".equals(dialect)) {
//            logger.warn("Property dialect is not setted,use default 'mysql' ");
//            dialect = defaultDialect;
//        }
//        pageSqlId = this.properties.getProperty("pageSqlId");
//       // pageSqlId = configuration.getVariables().getProperty("pageSqlId");
//        if (null == pageSqlId || "".equals(pageSqlId)) {
//            logger.warn("Property pageSqlId is not setted,use default '.*Page$' ");
//            pageSqlId = defaultPageSqlId;
//        }
//        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
//        // ֻ��д��Ҫ��ҳ��sql��䡣ͨ��MappedStatement��IDƥ�䣬Ĭ����д��Page��β��MappedStatement��sql
//        if (mappedStatement.getId().matches(pageSqlId)) {
//            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
//            Object parameterObject = boundSql.getParameterObject();
//            if (parameterObject == null) {
//                throw new NullPointerException("parameterObject is null!");
//            } else {
//            	// ��ҳ������Ϊ��������parameterObject��һ������
//            	/**
//            	 * �˴��ر�Ҫע���Ӧ��mpper.java��Ҫ����page���parameter��
//            	 * �磺public List<Store> getStoreListByPage(@Param("store")Store store,@Param("page")Pagination page);
//            	 * ���û��@Param("page")Pagination page�ᱨ��
//            	 */
//            	PageParameter page = (PageParameter) metaStatementHandler.getValue("delegate.boundSql.parameterObject.page");
//                String sql = boundSql.getSql();
//                // ��дsql
//                String pageSql = buildPageSql(sql, page);
//                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
//                // ���������ҳ�󣬾Ͳ���Ҫmybatis���ڴ��ҳ�ˣ����������������������
//                metaStatementHandler.setValue("delegate.rowBounds.offset", 
//                RowBounds.NO_ROW_OFFSET);
//                metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
//                Connection connection = (Connection) invocation.getArgs()[0];
//                // �����ҳ���������ҳ����
//                setPageParameter(sql, connection, mappedStatement, boundSql, page);
//            }
//        }
//        // ��ִ��Ȩ������һ��������
//        return invocation.proceed();
//    }
//
//    /**
//     * �����ݿ����ѯ�ܵļ�¼����������ҳ������д����ҳ����<code>PageParameter</code>,���������߾Ϳ���ͨ�� ��ҳ����
//     * <code>PageParameter</code>��������Ϣ��
//     * 
//     * @param sql
//     * @param connection
//     * @param mappedStatement
//     * @param boundSql
//     * @param page
//     */
//    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
//            BoundSql boundSql, PageParameter page) {
//        // ��¼�ܼ�¼��
//        String countSql = "select count(0) from (" + sql + ") as total";
//        PreparedStatement countStmt = null;
//        ResultSet rs = null;
//        try {
//            countStmt = connection.prepareStatement(countSql);
//            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
//                    boundSql.getParameterMappings(), boundSql.getParameterObject());
//            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
//            rs = countStmt.executeQuery();
//            int totalCount = 0;
//            if (rs.next()) {
//                totalCount = rs.getInt(1);
//            }
//            page.setTotalCount(totalCount);
//            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
//            page.setTotalPage(totalPage);
//
//        } catch (SQLException e) {
//            logger.error("Ignore this exception", e);
//        } finally {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                logger.error("Ignore this exception", e);
//            }
//            try {
//                countStmt.close();
//            } catch (SQLException e) {
//                logger.error("Ignore this exception", e);
//            }
//        }
//
//    }
//
//    /**
//     * ��SQL����(?)��ֵ
//     * 
//     * @param ps
//     * @param mappedStatement
//     * @param boundSql
//     * @param parameterObject
//     * @throws SQLException
//     */
//    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
//            Object parameterObject) throws SQLException {
//        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
//        parameterHandler.setParameters(ps);
//    }
//
//    /**
//     * �������ݿ����ͣ������ض��ķ�ҳsql
//     * 
//     * @param sql
//     * @param page
//     * @return
//     */
//    private String buildPageSql(String sql, PageParameter page) {
//        if (page != null) {
//            StringBuilder pageSql = new StringBuilder();
//            if ("mysql".equals(dialect)) {
//                pageSql = buildPageSqlForMysql(sql, page);
//            } else if ("oracle".equals(dialect)) {
//                pageSql = buildPageSqlForOracle(sql, page);
//            } else {
//                return sql;
//            }
//            return pageSql.toString();
//        } else {
//            return sql;
//        }
//    }
//
//    /**
//     * mysql�ķ�ҳ���
//     * 
//     * @param sql
//     * @param page
//     * @return String
//     */
//    public StringBuilder buildPageSqlForMysql(String sql, PageParameter page) {
//        StringBuilder pageSql = new StringBuilder(100);
//        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
//        pageSql.append(sql);
//        pageSql.append(" limit " + beginrow + "," + page.getPageSize());
//        return pageSql;
//    }
//
//    /**
//     * �ο�hibernate��ʵ�����oracle�ķ�ҳ
//     * 
//     * @param sql
//     * @param page
//     * @return String
//     */
//    public StringBuilder buildPageSqlForOracle(String sql, PageParameter page) {
//        StringBuilder pageSql = new StringBuilder(100);
//        String beginrow = String.valueOf((page.getCurrentPage() - 1) * page.getPageSize());
//        String endrow = String.valueOf(page.getCurrentPage() * page.getPageSize());
//
//        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
//        pageSql.append(sql);
//        pageSql.append(" ) temp where rownum <= ").append(endrow);
//        pageSql.append(") where row_id > ").append(beginrow);
//        return pageSql;
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        // ��Ŀ������StatementHandler����ʱ���Ű�װĿ���࣬����ֱ�ӷ���Ŀ�걾��,����Ŀ�걻����Ĵ���
//        if (target instanceof StatementHandler) {
//            return Plugin.wrap(target, this);
//        } else {
//            return target;
//        }
//    }
//
//}
// 