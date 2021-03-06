/*
 * Copyright (C) 2017 Christopher Towner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ihm.netsuite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Test of iHM's Account Executive dashboard on Netsuite.
 *
 * @author Christopher Towner
 */
public class AccountExecutiveDashboardTest extends NetsuiteTest {

    @Test
    public void testPortletHeaders() {
        System.out.println("testPortletHeaders");

        List<String> expected = new LinkedList<>(
                Arrays.asList("Shortcuts", "iHM Adjustments", "iHM Special Billing Requests",
                        "Settings", "AE Invoice Search", "iHM Payments", "Radio A/R Aging Dashboard",
                        "Non-Radio A/R Aging Dashboard", "KPI Meter", "Key Performance Indicators",
                        "Top 10 Clients By Balance"));

        for (WebElement e : driver.findElements(By.className("ns-portlet-header-text"))) {
            if (!expected.remove(e.getText())) {
                System.err.println("Found unexpected portlet header: " + e.getText());
            }
        }

        //assert all expected headers present
        assertTrue(expected.isEmpty());
    }

}
