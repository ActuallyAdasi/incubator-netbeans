/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.lib.profiler.tests.jfluid.cpu;

import junit.framework.Test;
import junit.textui.TestRunner;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.lib.profiler.ProfilerEngineSettings;
import org.netbeans.lib.profiler.filters.InstrumentationFilter;
import org.netbeans.lib.profiler.global.CommonConstants;

/**
 *
 * @author ehucka
 */
public class BasicTest extends CPUTestCase {
    //~ Static fields/initializers -----------------------------------------------------------------------------------------------

    private static final long MAX_DELAY = 25000L;
    
    public static final String[] tests = new String[]{
        /*"testLiveResultsAll",
        "testLiveResultsBasic",
        "testLiveResultsWaitEager",
        "testLiveResultsWaitLazy",
        "testLiveResultsWaitSampled", // not stable */
        "testLiveResultsWaitServer",
        "testLiveResultsWaitTotal",
        "testMethodWithWaitEager",
        "testMethodWithWaitEagerServer",
        "testMethodWithWaitExcludeWEager",
        "testMethodWithWaitExcludeWLazy",
        "testMethodWithWaitExcludeWTotal",
        "testMethodWithWaitLazy"
    };
    public static final String[] tests2 = new String[]{
        "testMethodWithWaitLazyServer",
        "testMethodWithWaitTotal",
        "testMethodWithWaitTotalServer",
        "testSettingsDefault", // not stable
        "testSettingsInstrumenManyMethodsLazy",
        "testSettingsInstrumentAllEager",
        "testSettingsInstrumentAllEagerServer",
        "testSettingsInstrumentAllLazy",
        "testSettingsInstrumentAllLazyServer",
        "testSettingsInstrumentAllTotal",
        "testSettingsInstrumentAllTotalServer",
        "testSettingsInstrumentExcludeJavas",
        "testSettingsInstrumentExcludeJavasServer"
    };
    public static final String[] tests3 = new String[]{
        "testSettingsInstrumentManyMethodsTotal",
        "testSettingsInstrumentNotSpawnedThreads",
        "testSettingsInstrumentNotSpawnedThreadsServer",
        "testSettingsInstrumentRootMethod",
        "testSettingsInstrumentRootMethodServer",
        "testSettingsLimitedThreads",
        "testSettingsLimitedThreadsServer",
        "testSettingsSampledProfilingEager",
        "testSettingsSampledProfilingLazy",
        "testSettingsSampledProfilingServerEager",
        "testSettingsSampledProfilingServerLazy",
        "testSettingsSampledProfilingServerTotal",
        "testSettingsSampledProfilingTotal"
    };

    //~ Constructors -------------------------------------------------------------------------------------------------------------
            /** Creates a new instance of BasicTest */

    public BasicTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        return NbModuleSuite.create(
                NbModuleSuite.createConfiguration(BasicTest.class).addTest(
                "testLiveResultsAll",
                "testLiveResultsBasic",
                "testLiveResultsWaitEager",
                "testLiveResultsWaitLazy",
                "testLiveResultsWaitSampled",
                "testLiveResultsWaitServer",
                "testLiveResultsWaitTotal",
                "testMethodWithWaitEager",
                "testMethodWithWaitEagerServer",
                "testMethodWithWaitExcludeWEager",
                "testMethodWithWaitExcludeWLazy",
                "testMethodWithWaitExcludeWTotal",
                "testMethodWithWaitLazy",
                 "testMethodWithWaitLazyServer",
                "testMethodWithWaitTotal",
                "testMethodWithWaitTotalServer",
                "testSettingsDefault",
//                "testSettingsInstrumenManyMethodsLazy", JVM crash 
                "testSettingsInstrumentAllEager",
                "testSettingsInstrumentAllEagerServer",
                "testSettingsInstrumentAllLazy",
                "testSettingsInstrumentAllLazyServer",
                "testSettingsInstrumentAllTotal",
                "testSettingsInstrumentAllTotalServer",
                "testSettingsInstrumentExcludeJavas",
                "testSettingsInstrumentExcludeJavasServer",
                "testSettingsInstrumentManyMethodsTotal",
                "testSettingsInstrumentNotSpawnedThreads",
                "testSettingsInstrumentNotSpawnedThreadsServer",
                "testSettingsInstrumentRootMethod",
                "testSettingsInstrumentRootMethodServer",
                "testSettingsLimitedThreads",
                "testSettingsLimitedThreadsServer",
                "testSettingsSampledProfilingEager",
                "testSettingsSampledProfilingLazy",
                "testSettingsSampledProfilingServerEager",
                "testSettingsSampledProfilingServerLazy",
                "testSettingsSampledProfilingServerTotal",
                "testSettingsSampledProfilingTotal"
                ).enableModules(".*").clusters(".*").gui(false));
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------
    public void temptestSettingsInstrumentRootMethod(boolean server) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1",
                new String[][]{
                    {"simple.cpu.CPUThread", "run", "()V"}
                });
        settings.setInstrumentSpawnedThreads(false);
        settings.setInstrumentMethodInvoke(true);
        settings.setInstrumentGetterSetterMethods(true);
        settings.setInstrumentEmptyMethods(true);
        settings.setInstrScheme(CommonConstants.INSTRSCHEME_LAZY);

        if (server) {
            addJVMArgs(settings, "-server");
        }

        startCPUTest(settings, new String[]{"simple.cpu.CPUThread.run512()"}, new long[]{512L}, 40.0,
                new String[]{"simple"}, ALL_INV_ERROR_METHOD);
    }

    public void testLiveResultsAll() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1");
        startCPUTest(settings, new String[]{""}, 1000, MAX_DELAY);
    }

    public void testLiveResultsBasic() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.CPU");
        startCPUTest(settings, new String[]{"simple"}, 1500, MAX_DELAY);
    }

    public void testLiveResultsWaitEager() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.WaitingTest");
        settings.setInstrScheme(CommonConstants.INSTRSCHEME_EAGER);
        startCPUTest(settings, new String[]{"simple"}, 1000, MAX_DELAY);
    }

    public void testLiveResultsWaitLazy() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.WaitingTest");
        settings.setInstrScheme(CommonConstants.INSTRSCHEME_LAZY);
        startCPUTest(settings, new String[]{"simple"}, 1000, MAX_DELAY);
    }

    public void testLiveResultsWaitSampled() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.WaitingTest");
        settings.setCPUProfilingType(CommonConstants.CPU_INSTR_SAMPLED);
        settings.setSamplingInterval(1);
        startCPUTest(settings, new String[]{"simple"}, 1000, MAX_DELAY);
    }

    public void testLiveResultsWaitServer() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.WaitingTest");
        addJVMArgs(settings, "-server");
        startCPUTest(settings, new String[]{"simple"}, 1000, MAX_DELAY);
    }

    public void testLiveResultsWaitTotal() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.WaitingTest");
        settings.setInstrScheme(CommonConstants.INSTRSCHEME_TOTAL);
        startCPUTest(settings, new String[]{"simple"}, 1000, MAX_DELAY);
    }

    public void testMethodWithWaitEager() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_EAGER, false, false, 2000L);
    }

    public void testMethodWithWaitEagerServer() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_EAGER, false, true, 2000L);
    }

    public void testMethodWithWaitExcludeWEager() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_EAGER, true, false, 4000L);
    }

    public void testMethodWithWaitExcludeWLazy() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_LAZY, true, false, 4000L);
    }

    public void testMethodWithWaitExcludeWTotal() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_TOTAL, true, false, 4000L);
    }

    public void testMethodWithWaitLazy() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_LAZY, false, false, 2000L);
    }

    public void testMethodWithWaitLazyServer() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_LAZY, false, true, 2000L);
    }

    public void testMethodWithWaitTotal() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_TOTAL, false, false, 2000L);
    }

    public void testMethodWithWaitTotalServer() {
        temptestMethodWithWait(CommonConstants.INSTRSCHEME_TOTAL, false, true, 2000L);
    }

    public void testSettingsDefault() {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1");
        startCPUTest(settings,
                new String[]{
                    "simple.cpu.Bean.run20()", "simple.cpu.Bean.run100()", "simple.cpu.Bean.run1000()",
                    "simple.cpu.CPUThread.run512()"
                }, new long[]{20L, 100L, 1000L, 512L}, 40.0, new String[]{"simple"}, ALL_INV_ERROR_METHOD);
    }

    public void testSettingsInstrumenManyMethodsLazy() {
        temptestSettingsInstrumentManyMethods(CommonConstants.INSTRSCHEME_LAZY);
    }

    public void testSettingsInstrumentAllEager() {
        temptestSettingsInstrumentAll(CommonConstants.INSTRSCHEME_EAGER, false);
    }

    public void testSettingsInstrumentAllEagerServer() {
        temptestSettingsInstrumentAll(CommonConstants.INSTRSCHEME_EAGER, true);
    }

    public void testSettingsInstrumentAllLazy() {
        temptestSettingsInstrumentAll(CommonConstants.INSTRSCHEME_LAZY, false);
    }

    public void testSettingsInstrumentAllLazyServer() {
        temptestSettingsInstrumentAll(CommonConstants.INSTRSCHEME_LAZY, true);
    }

    public void testSettingsInstrumentAllTotal() {
        temptestSettingsInstrumentAll(CommonConstants.INSTRSCHEME_TOTAL, false);
    }

    public void testSettingsInstrumentAllTotalServer() {
        temptestSettingsInstrumentAll(CommonConstants.INSTRSCHEME_TOTAL, true);
    }

    public void testSettingsInstrumentExcludeJavas() {
        temptestSettingsInstrumentExcludeJavas(false);
    }

    public void testSettingsInstrumentExcludeJavasServer() {
        temptestSettingsInstrumentExcludeJavas(true);
    }

    public void testSettingsInstrumentManyMethodsTotal() {
        temptestSettingsInstrumentManyMethods(CommonConstants.INSTRSCHEME_TOTAL);
    }

    public void testSettingsInstrumentNotSpawnedThreads() {
        temptestSettingsInstrumentNotSpawnedThreads(false);
    }

    public void testSettingsInstrumentNotSpawnedThreadsServer() {
        temptestSettingsInstrumentNotSpawnedThreads(true);
    }

    public void testSettingsInstrumentRootMethod() {
        temptestSettingsInstrumentRootMethod(false);
    }

    public void testSettingsInstrumentRootMethodServer() {
        temptestSettingsInstrumentRootMethod(true);
    }

    public void testSettingsLimitedThreads() {
        temptestSettingsLimitedThreads(false);
    }

    public void testSettingsLimitedThreadsServer() {
        temptestSettingsLimitedThreads(true);
    }

    public void testSettingsSampledProfilingEager() {
        temptestSettingsSampledProfiling(false, CommonConstants.INSTRSCHEME_EAGER);
    }

    public void testSettingsSampledProfilingLazy() {
        temptestSettingsSampledProfiling(false, CommonConstants.INSTRSCHEME_LAZY);
    }

    public void testSettingsSampledProfilingServerEager() {
        temptestSettingsSampledProfiling(true, CommonConstants.INSTRSCHEME_EAGER);
    }

    public void testSettingsSampledProfilingServerLazy() {
        temptestSettingsSampledProfiling(true, CommonConstants.INSTRSCHEME_LAZY);
    }

    public void testSettingsSampledProfilingServerTotal() {
        temptestSettingsSampledProfiling(true, CommonConstants.INSTRSCHEME_TOTAL);
    }

    public void testSettingsSampledProfilingTotal() {
        temptestSettingsSampledProfiling(false, CommonConstants.INSTRSCHEME_TOTAL);
    }

    protected void temptestMethodWithWait(int instrscheme, boolean withwaits, boolean server, long idealtime) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.WaitingTest",
                new String[][]{
                    {"simple.cpu.WaitingTest", "method1000", "()V"}
                });
        settings.setInstrScheme(instrscheme);
        settings.setExcludeWaitTime(!withwaits);

        if (server) {
            addJVMArgs(settings, "-server");
        }

        startCPUTest(settings, new String[]{"simple.cpu.WaitingTest.method1000()"}, new long[]{idealtime}, 40.0,
                new String[]{"simple"}, ALL_INV_ERROR_METHOD);
    }

    protected void temptestSettingsInstrumentAll(int instrScheme, boolean server) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1");
        settings.setInstrumentSpawnedThreads(true);
        settings.setInstrumentMethodInvoke(true);
        settings.setInstrumentGetterSetterMethods(true);
        settings.setInstrumentEmptyMethods(true);
        settings.setInstrScheme(instrScheme);

        if (server) {
            addJVMArgs(settings, "-server");
        }

        startCPUTest(settings,
                new String[]{
                    "simple.cpu.Bean.run20()", "simple.cpu.Bean.run100()", "simple.cpu.Bean.run1000()",
                    "simple.cpu.CPUThread.run512()"
                }, new long[]{20L, 100L, 1000L, 512L}, 40.0, new String[]{"simple"}, ALL_INV_ERROR_METHOD);
    }

    protected void temptestSettingsInstrumentExcludeJavas(boolean server) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1");
        settings.setInstrumentSpawnedThreads(true);
        settings.setInstrumentMethodInvoke(true);
        settings.setInstrumentGetterSetterMethods(false);
        settings.setInstrumentEmptyMethods(false);
        settings.setInstrScheme(CommonConstants.INSTRSCHEME_LAZY);

        if (server) {
            addJVMArgs(settings, "-server");
        }

        // TODO: fix for the new filters!
        InstrumentationFilter filter = new InstrumentationFilter();
        filter.setType(InstrumentationFilter.TYPE_EXCLUSIVE);
        filter.setValue("java");
        settings.setInstrumentationFilter(filter);
        startCPUTest(settings,
                new String[]{
                    "simple.cpu.Bean.run20()", "simple.cpu.Bean.run100()", "simple.cpu.Bean.run1000()",
                    "simple.cpu.CPUThread.run512()"
                }, new long[]{20L, 100L, 1000L, 512L}, 40.0, new String[]{"simple", "java"}, ALL_INV_ERROR_METHOD);
    }

    protected void temptestSettingsInstrumentManyMethods(int instrscheme) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.Methods2");
        settings.setInstrumentSpawnedThreads(true);
        settings.setInstrumentMethodInvoke(true);
        settings.setInstrumentGetterSetterMethods(true);
        settings.setInstrumentEmptyMethods(true);
        settings.setInstrScheme(instrscheme);
        startCPUTest(settings, new String[]{"simple.cpu.Methods2.method0()"}, new long[]{400L}, 40.0,
                new String[]{"simple.cpu.Methods2.method1"}, ALL_INV_ERROR_METHOD);
    }

    protected void temptestSettingsInstrumentNotSpawnedThreads(boolean server) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1");
        settings.setInstrumentSpawnedThreads(false);
        settings.setInstrumentMethodInvoke(true);
        settings.setInstrumentGetterSetterMethods(true);
        settings.setInstrumentEmptyMethods(true);
        settings.setInstrScheme(CommonConstants.INSTRSCHEME_LAZY);

        if (server) {
            addJVMArgs(settings, "-server");
        }

        startCPUTest(settings,
                new String[]{
                    "simple.cpu.Bean.run20()", "simple.cpu.Bean.run100()", "simple.cpu.Bean.run1000()",
                    "simple.cpu.CPUThread.run512()"
                }, new long[]{20L, 100L, 1000L, 512L}, 40.0, new String[]{"simple"}, ALL_INV_ERROR_METHOD);
    }

    protected void temptestSettingsLimitedThreads(boolean server) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1");
        settings.setInstrumentSpawnedThreads(true);
        settings.setInstrumentMethodInvoke(true);
        settings.setInstrumentGetterSetterMethods(true);
        settings.setInstrumentEmptyMethods(true);
        settings.setNProfiledThreadsLimit(1);
        settings.setInstrScheme(CommonConstants.INSTRSCHEME_LAZY);

        if (server) {
            addJVMArgs(settings, "-server");
        }

        startCPUTest(settings,
                new String[]{
                    "simple.cpu.Bean.run20()", "simple.cpu.Bean.run100()", "simple.cpu.Bean.run1000()",
                    "simple.cpu.CPUThread.run512()"
                }, new long[]{20L, 100L, 1000L, 512L}, 40.0, new String[]{"simple"}, ALL_INV_ERROR_METHOD);
    }

    protected void temptestSettingsSampledProfiling(boolean server, int instrScheme) {
        ProfilerEngineSettings settings = initCpuTest("j2se-simple", "simple.cpu.CPU1");
        settings.setInstrumentSpawnedThreads(true);
        settings.setInstrumentMethodInvoke(true);
        settings.setInstrumentGetterSetterMethods(true);
        settings.setInstrumentEmptyMethods(true);
        settings.setCPUProfilingType(CommonConstants.CPU_INSTR_SAMPLED);
        settings.setSamplingInterval(5);
        settings.setInstrScheme(instrScheme);

        if (server) {
            addJVMArgs(settings, "-server");
        }

        startCPUTest(settings,
                new String[]{
                    "simple.cpu.Bean.run20()", "simple.cpu.Bean.run100()", "simple.cpu.Bean.run1000()",
                    "simple.cpu.CPUThread.run512()"
                }, new long[]{20L, 100L, 1000L, 512L}, 40.0, new String[]{"simple"}, ALL_INV_ERROR_METHOD);
    }
}
