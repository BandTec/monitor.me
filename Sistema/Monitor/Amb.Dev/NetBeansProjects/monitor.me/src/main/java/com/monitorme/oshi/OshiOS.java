package com.monitorme.oshi;

import com.sun.jna.Platform;
import java.io.Serializable;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.software.os.linux.LinuxOperatingSystem;
import oshi.software.os.mac.MacOperatingSystem;
import oshi.software.os.unix.freebsd.FreeBsdOperatingSystem;
import oshi.software.os.unix.solaris.SolarisOperatingSystem;
import oshi.software.os.windows.WindowsOperatingSystem;

public class OshiOS implements Serializable {
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    CentralProcessor cpu = hal.getProcessor();
    
    private static final PlatformEnum currentPlatformEnum;
    private OperatingSystem os = null;
    
    static {
        if (Platform.isWindows()) {
            currentPlatformEnum = PlatformEnum.WINDOWS;
        } else if (Platform.isLinux()) {
            currentPlatformEnum = PlatformEnum.LINUX;
        } else if (Platform.isMac()) {
            currentPlatformEnum = PlatformEnum.MACOSX;
        } else if (Platform.isSolaris()) {
            currentPlatformEnum = PlatformEnum.SOLARIS;
        } else if (Platform.isFreeBSD()) {
            currentPlatformEnum = PlatformEnum.FREEBSD;
        } else {
            currentPlatformEnum = PlatformEnum.UNKNOWN;
        }
    }
    
    public static PlatformEnum getCurrentPlatformEnum() {
        return currentPlatformEnum;
    }
    
    public OperatingSystem getOperatingSystem() {
        if (this.os == null) {
            switch (currentPlatformEnum) {

            case WINDOWS:
                this.os = new WindowsOperatingSystem();
                break;
            case LINUX:
                this.os = new LinuxOperatingSystem();
                break;
            case MACOSX:
                this.os = new MacOperatingSystem();
                break;
            case SOLARIS:
                this.os = new SolarisOperatingSystem();
                break;
            case FREEBSD:
                this.os = new FreeBsdOperatingSystem();
                break;
            default:
                throw new UnsupportedOperationException("Operating system not supported: " + Platform.getOSType());
            }
        }
        return this.os;
    }
}
