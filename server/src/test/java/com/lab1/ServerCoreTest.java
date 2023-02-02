package com.lab1;

import com.server.ServerCore;
import org.junit.jupiter.api.Test;
import com.controllers.TerminalController;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.*;

public class ServerCoreTest {
    @Test
    public void instanceTest() {
        ServerCore s1 = ServerCore.getInstance();
        ServerCore s2 = ServerCore.getInstance();
        assertEquals(s1, s2);
        assertNotNull(s1);
    }

    private static class DummyController extends TerminalController {
        public String append;

        @Override
        public void append(String text) {
            append = text;
        }
    }

    @Test
    public void commandTest() {
        ServerCore.getInstance().setController(new DummyController());
        ServerCore.getInstance().command("echo test1234");
        assertEquals(" test1234", ((DummyController) ServerCore.getInstance().getController()).append);
    }

    private static class DummySocket extends ServerSocket {
        public boolean amIactive = true;

        public DummySocket() throws IOException {
        }

        @Override
        public void close() throws IOException {
            amIactive = false;
        }
    }

    @Test
    public void closeTest() throws IOException {
        DummyController dc = new DummyController();
        ServerCore.getInstance().setController(dc);
        DummySocket ds = new DummySocket();
        ServerCore.getInstance().serverSocket = ds;
        ServerCore.getInstance().close(true);
        assertEquals(dc.append, "server closed");
        assertNotNull(ServerCore.getInstance().getUsers());
        assertFalse(ds.amIactive);
    }

    @Test
    public void startTest() {
        DummyController dc = new DummyController();
        ServerCore.getInstance().setController(dc);
        ServerCore.getInstance().command("start 4444");
        assertEquals(dc.append, "started server at port 4444");
    }
}
