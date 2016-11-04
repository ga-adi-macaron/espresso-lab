package ly.generalassemb.espresso;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewTransactionActivityTest {

    @Rule
    public ActivityTestRule<NewTransactionActivity> mActivityTestRule = new ActivityTestRule<>(NewTransactionActivity.class);

    @Test
    public void withdrawTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("Bought a rocket ship"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("12541063"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton.perform(click());
    }

    @Test
    public void depositTest() {

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("sold the rocket ship"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("75.00"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

    }

}
