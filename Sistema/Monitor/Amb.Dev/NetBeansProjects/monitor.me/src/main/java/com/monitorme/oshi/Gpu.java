package com.monitorme.oshi;

import static com.monitorme.oshi.SystemInfoTest.oshi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Gpu implements Serializable {
    
    private static final Logger logger = LoggerFactory.getLogger(Gpu.class);
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    static List<String> oshi = new ArrayList<>();
    
    public void printGPU() {
        logger.info("Checking Graphics Cards...");
        printGraphicsCards(hal.getGraphicsCards());
        
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < oshi.size(); i++) {
            output.append(oshi.get(i));
            if (oshi.get(i) != null && !oshi.get(i).endsWith("\n")) {
                output.append('\n');
            }
        }
        logger.info("Printing Operating System and Hardware Info:{}{}", '\n', output);
    }
    

    private static void printGraphicsCards(GraphicsCard[] cards) {
        oshi.add("Graphics Cards:");
        if (cards.length == 0) {
            oshi.add(" None detected.");
        } else {
            for (GraphicsCard card : cards) {
                oshi.add(" " + String.valueOf(card));
            }
        }
    }
}
