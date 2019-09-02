package com.prealation.test.client;

import com.prealation.test.ds.Configuration;
import com.prealation.test.ds.DbProvider;
import com.prealation.test.service.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientTest {

    private static final Logger log = LogManager.getLogger(ClientTest.class);

    Router router = new Router();

    static final String ALIVE = "{\"jsonrpc\": \"2.0\", \"method\": \"isAlive\", \"id\": 1}";
    static final String ADD_CATEGORY = "{\"jsonrpc\": \"2.0\", \"method\": \"createCategory\", \"params\": [\"Church\", \"BLUE\"]}";
    static final String ADD_CATEGORY_RETURN = "{\"jsonrpc\": \"2.0\", \"method\": \"createAndReturnCategory\", \"params\": [\"School\", \"ORANGE\"], \"id\": 1}";

    public static void main(String[] args) {
        new ClientTest().start();
        DbProvider.close();
    }

    private void start() {
        log.info(Configuration.server().handle(ALIVE, router));
        log.info(Configuration.server().handle(ADD_CATEGORY, router));
        log.info(Configuration.server().handle(ADD_CATEGORY_RETURN, router));
    }
}
