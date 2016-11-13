package com.tc.tccp.core.exception; 
/** 
 * @author wangpei 
 * @version 
 *创建时间：2016年9月21日 下午7:45:35 
 * 类说明 
 */
public class EntityException extends RuntimeException 
{
    private static final long serialVersionUID = 1L;

    public EntityException() {
        super();
    }

    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
 