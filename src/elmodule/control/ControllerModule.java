package elmodule.control;

import emergencylanding.k.exst.modules.IModule;
import emergencylanding.k.library.main.KMain;

public class ControllerModule extends IModule {
    public static final String FULL_BINARY_NAME = ControllerModule.class
            .getName();

    private ControllerModule() {
        throw new AssertionError("Don't build this, get it from ModuleSystem!");
    }

    @Override
    public void init(KMain instance) {
        System.err.println("Loaded Controllers via Mods interface.");
    }

}
