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
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mActivityTestRule = new ActivityTestRule<>(BalanceActivity.class);

    @Test
    public void balanceActivityTest() {

        ViewInteraction balanceTextView = onView(withId(R.id.balanceTextView));
        balanceTextView.check(matches(isDisplayed())); //Check if we can see our empty bank account balance.

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click()); //Clicked on the Fab to move to transaction screen.

        ViewInteraction descEditText = onView(withId(R.id.descriptionEditText));//Get description edit text.
        descEditText.perform(typeText("Payment from MLM suckers"));

        ViewInteraction amountEditText = onView(withId(R.id.amountEditText));
        amountEditText.perform(typeText("12482"));

        onView(withId(R.id.depositButton)).perform(click()); //At this point we should have gone back to mainscreen.

        balanceTextView.check(matches(withText("$12,482.00")));//Check to see if our balance properly updated to show deposit.

        floatingActionButton.perform(click()); //Go back to the transaction screen

        descEditText.perform(typeText("Gonna try some crack"));
        amountEditText.perform(typeText("223.42"));

        onView(withId(R.id.withdrawButton)).perform(click()); //Takes us back to balance activity

        balanceTextView.check(matches(withText("$12,258.58"))); //Check to see if balance properly updated to show withdrawal.

        floatingActionButton.perform(click());
        descEditText.perform(typeText("Crack is pretty good"));
        amountEditText.perform(typeText("421.30"));
        onView(withId(R.id.withdrawButton)).perform(click());

        balanceTextView.check(matches(withText("$11,837.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText("Man, I love crack"));
        amountEditText.perform(typeText("571"));
        onView(withId(R.id.withdrawButton)).perform(click());

        balanceTextView.check(matches(withText("$11,266.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText("I might be addicted"));
        amountEditText.perform(typeText("1378"));
        onView(withId(R.id.withdrawButton)).perform(click());

        balanceTextView.check(matches(withText("$9,888.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText("Just a little more"));
        amountEditText.perform(typeText("3202"));
        onView(withId(R.id.withdrawButton)).perform(click());

        balanceTextView.check(matches(withText("$6,686.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText("Senate Paycheck"));
        amountEditText.perform(typeText("34750"));
        onView(withId(R.id.depositButton)).perform(click());

        balanceTextView.check(matches(withText("$41,436.28")));

    }

}
