package com.tc.tccp.core.exception; 
/** 
 * @author wangpei 
 * @version 
 *����ʱ�䣺2016��9��21�� ����7:45:35 
 * ��˵�� 
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
 