package receipt.Read;

public class ReadFactory {
    private enum ReadType {
        FILE {
            Read create() {
                return new ReadFile();
            }
        },
        CONSOLE {
            Read create() {
                return new ReadConsole();
            }
        };

        abstract Read create();
    }

    public static Read getFromFactory(String type) {
        return ReadType.valueOf(type).create();
    }
}
