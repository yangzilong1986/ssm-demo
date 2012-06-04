package org.colorfuldays.ssm.util;

import com.google.code.ssm.api.*;
import com.google.code.ssm.api.format.UseJson;
import org.colorfuldays.ssm.domain.Session;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: huxing(xing.hu@360hqb.com)
 * Date: 12-5-28
 * Time: 下午12:00
 */
@Service
public class SessionManager {


    @UpdateSingleCache(namespace = "star", expiration = 60)
    @UseJson
    @ReturnDataUpdateContent
    public Session updateSession(@ParameterValueKeyProvider Session session) {
        session.setAttribute("sign","1234569");
        return session;
    }

    @ReadThroughSingleCache(namespace = "star", expiration = 60)
    @UseJson
    public Session getSession(@ParameterValueKeyProvider long sessionId) {
        Session session = new Session();
        session.setSessionId(112321);
        session.setAttribute("name", "session");
        session.setAttribute("sign", "12345678");
        session.setAttribute("group", "dba");
        return session;
    }

    @InvalidateSingleCache
    public void cleanSession(@ParameterValueKeyProvider long sessionId) {
    }
}
