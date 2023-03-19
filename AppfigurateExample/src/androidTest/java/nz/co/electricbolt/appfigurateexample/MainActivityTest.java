// MainActivityTest.java
// AppfigurateExample Copyright © 2023; Electric Bolt Limited.

package nz.co.electricbolt.appfigurateexample;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import nz.co.electricbolt.appfiguratelibrary.Configuration;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static nz.co.electricbolt.appfigurateexample.RecyclerViewMatcher.atPosition;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private ExampleConfiguration config;

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        config = (ExampleConfiguration) Configuration.sharedConfiguration();
        config.automationReset();
    }

    @Test
    public void test_1_Reset() {
        onView(withId(R.id.recycler_view)).check(matches(atPosition(0, hasDescendant(withText("true")))));
    }

    @Test
    public void test_2_BooleanValue() {
        onView(withId(R.id.recycler_view)).check(matches(atPosition(0, hasDescendant(withText("true")))));
        config.bool = false;
        config.automationApply();
        onView(withId(R.id.recycler_view)).check(matches(atPosition(0, hasDescendant(withText("false")))));
    }

    @Test
    public void test_3_String_Textfield_Value() {
        onView(withId(R.id.recycler_view)).check(matches(atPosition(1, hasDescendant(withText("tuesday")))));
        config.string_Textfield = "thursday";
        config.automationApply();
        onView(withId(R.id.recycler_view)).check(matches(atPosition(1, hasDescendant(withText("thursday")))));
    }

    @Test
    public void test_4_Action() {
        onView(withId(R.id.recycler_view)).check(matches(atPosition(8, hasDescendant(withText("500")))));
        config.automationAction("randomIntegers");
        onView(withId(R.id.recycler_view)).check(matches(atPosition(8, hasDescendant(not(withText("500"))))));
    }

}