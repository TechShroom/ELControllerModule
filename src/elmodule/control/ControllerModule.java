package elmodule.control;

import k.core.util.classes.StackTraceInfo;
import emergencylanding.k.exst.modules.IModule;
import emergencylanding.k.library.main.KMain;
import emergencylanding.k.library.util.LUtils;

public class ControllerModule extends IModule {
    public static final String FULL_BINARY_NAME = ControllerModule.class
            .getName();

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
        System.err.println("Loaded Controllers via Mods interface.");
    }

}
