package org.libelektra;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({KeySetTest.class, KeyTest.class, KDBTest.class, ExceptionMapperTest.class,
        KDBExceptionTest.class, ExceptionMapperIT.class})
public class AllTests {

}