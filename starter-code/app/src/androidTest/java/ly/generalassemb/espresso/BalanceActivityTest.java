package ly.generalassemb.espresso;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mActivityTestRule = new ActivityTestRule<>(BalanceActivity.class);

    @Test
    public void ViewCurrentBalance() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));
    }

    @Test
    public void CanDeposit() {
        //Start new transaction - DEPOSIT
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("Deposit"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("100.00"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), isDisplayed()));
        appCompatButton.perform(click());

        //Check Transaction shows up in list of transactions
        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        //Check if transaction name/type/amount are correct
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.balance_item_description),
                        isDisplayed()));
        textView2.check(matches(withText("Deposit")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.balance_item_amount),
                        isDisplayed()));
        textView3.check(matches(withText("$100.00")));

        //Check Balance amount is correct
        ViewInteraction textView4 = onView(
                allOf(withId(R.id.balanceTextView),
                        isDisplayed()));
        textView4.check(matches(withText("$100.00")));
    }
    @Test
    public void CanWithdraw() {
        //Start new Transaction - WITHDRAWAL
        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText3.perform(replaceText("Withdrawal"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText4.perform(replaceText("50"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.withdrawButton), isDisplayed()));
        appCompatButton2.perform(click());

        //Check if it shows in list
        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout2.check(matches(isDisplayed()));

        //Check if transaction name/type/amount are correct
        ViewInteraction textView5 = onView(
                allOf(withId(R.id.balance_item_description),
                        isDisplayed()));
        textView5.check(matches(withText("Withdrawal")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.balance_item_amount),
                        isDisplayed()));
        textView6.check(matches(withText("-$50.00")));

        //Check if balance is correct
        ViewInteraction textView7 = onView(
                allOf(withId(R.id.balanceTextView),
                        isDisplayed()));
        textView7.check(matches(withText("-$50.00")));
    }

    @Test
    public void MultiTransaction(){
        //Start first Transaction
        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText5.perform(replaceText("Multi Transaction 1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText6.perform(replaceText("55"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.depositButton), isDisplayed()));
        appCompatButton3.perform(click());

        //Start second Transaction
        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText7.perform(replaceText("Multi Transactin2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText8.perform(replaceText("1000"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.depositButton), isDisplayed()));
        appCompatButton4.perform(click());

        //Check list for both new transactions
            //Deposit 1
        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));
            //Deposit 2
        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout4.check(matches(isDisplayed()));
        //Check if Balance is correct
        ViewInteraction textView8 = onView(
                allOf(withId(R.id.balanceTextView),
                        isDisplayed()));
        textView8.check(matches(withText("$1,055.00")));

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
