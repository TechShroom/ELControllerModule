package elmodule.control;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

import k.core.util.classes.StackTraceInfo;
import emergencylanding.k.exst.modules.IModule;
import emergencylanding.k.library.main.KMain;
import emergencylanding.k.library.util.LUtils;

public class ControllerModule extends IModule {
    private Controller[] controllers = new Controller[0];

    public ControllerModule() {
        try {
            LUtils.checkAccessor(
                    new String[] { "sun.reflect.NativeConstructorAccessorImpl" },
                    StackTraceInfo.getInvokingClassName());
        } catch (Exception e) {
            throw new IllegalAccessError(
                    "Don't call controller module constructor");
        }
    }

    @Override
    public void init(KMain instance) {
        System.err.println("Loading Controllers...");
        try {
            Controllers.create();
        } catch (LWJGLException e) {
            System.err.println("Failed.");
            throw new RuntimeException(e);
        }
        controllers = new Controller[Controllers.getControllerCount()];
        for (int i = 0; i < controllers.length; i++) {
            controllers[i] = Controllers.getController(i);
            System.err.println("Loading controller (id: " + i + ") of type "
                    + controllerToString(controllers[i]) + ".");
        }
        System.err.println("Loaded Controllers via Mods interface.");
    }

    public static String controllerToString(Controller c) {
        return c.getName() + ": [axisCount: " + c.getAxisCount()
                + ", buttonCount: " + c.getButtonCount() + ", rumblerCount: "
                + c.getRumblerCount() + "]";
    }

    public Controller[] getControllers() {
        return controllers;
    }
}
