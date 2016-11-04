package ly.generalassemb.espresso;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;


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

        int numOfTransactions= 0;
        String[][] transactions = {{"Payment from MLM suckers","12482"},{"Gonna try some crack","223.42"},{"Crack is pretty good","421.30"}
        ,{"Man, I love crack","571"},{"I might be addicted","1378"},{"Just a little more","3202"},{"Senate Paycheck","34750"}};


        ViewInteraction balanceTextView = onView(withId(R.id.balanceTextView));
        balanceTextView.check(matches(isDisplayed())); //Check if we can see our empty bank account balance.

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click()); //Clicked on the Fab to move to transaction screen.

        ViewInteraction descEditText = onView(withId(R.id.descriptionEditText));//Get description edit text.
        descEditText.perform(typeText(transactions[0][0]));

        ViewInteraction amountEditText = onView(withId(R.id.amountEditText));
        amountEditText.perform(typeText(transactions[0][1]));

        onView(withId(R.id.depositButton)).perform(click()); //At this point we should have gone back to mainscreen.
        numOfTransactions++;

        balanceTextView.check(matches(withText("$12,482.00")));//Check to see if our balance properly updated to show deposit.

        floatingActionButton.perform(click()); //Go back to the transaction screen

        descEditText.perform(typeText(transactions[1][0]));
        amountEditText.perform(typeText(transactions[1][1]));

        onView(withId(R.id.withdrawButton)).perform(click()); //Takes us back to balance activity
        numOfTransactions++;

        balanceTextView.check(matches(withText("$12,258.58"))); //Check to see if balance properly updated to show withdrawal.

        floatingActionButton.perform(click());
        descEditText.perform(typeText(transactions[2][0]));
        amountEditText.perform(typeText(transactions[2][1]));
        onView(withId(R.id.withdrawButton)).perform(click());
        numOfTransactions++;

        balanceTextView.check(matches(withText("$11,837.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText(transactions[3][0]));
        amountEditText.perform(typeText(transactions[3][1]));
        onView(withId(R.id.withdrawButton)).perform(click());
        numOfTransactions++;

        balanceTextView.check(matches(withText("$11,266.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText(transactions[4][0]));
        amountEditText.perform(typeText(transactions[4][1]));
        onView(withId(R.id.withdrawButton)).perform(click());
        numOfTransactions++;

        balanceTextView.check(matches(withText("$9,888.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText(transactions[5][0]));
        amountEditText.perform(typeText(transactions[5][1]));
        onView(withId(R.id.withdrawButton)).perform(click());
        numOfTransactions++;

        balanceTextView.check(matches(withText("$6,686.28")));

        floatingActionButton.perform(click());
        descEditText.perform(typeText(transactions[6][0]));
        amountEditText.perform(typeText(transactions[6][1]));
        onView(withId(R.id.depositButton)).perform(click());
        numOfTransactions++;

        balanceTextView.check(matches(withText("$41,436.28")));


        for(int i = 0; i<numOfTransactions;i++){ //I'm not sure if this is doing what I think it's doing, but the idea is that this checks that the transactions match up with what's displayed.
            childAtPosition(withId(R.id.transactionsListView),i).matches(allOf(withId(R.id.balance_item_description), withText(transactions[i][0])));
            childAtPosition(withId(R.id.transactionsListView),i).matches(allOf(withId(R.id.balance_item_amount),withText(transactions[i][1])));

        }


    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
