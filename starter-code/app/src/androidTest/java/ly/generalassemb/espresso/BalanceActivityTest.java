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
    public void balanceActivityTest() {
        /**
         * Check if the balance and amount exist
         */
        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceLabel), withText("Balance"),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.balanceTextView), withText("$0.00"),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        /**
         * Check Button is clickable
         */

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.check(matches(isClickable()));
        floatingActionButton.perform(click());

        /**
         * Perform inputting and check if input is avalable
         */

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.check(matches(isFocusable()));
        appCompatEditText.perform(replaceText("Chrck"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.check(matches(isFocusable()));
        appCompatEditText2.perform(replaceText("1000"), closeSoftKeyboard());

        /**
         * Check if the two button exist
         */

        ViewInteraction button = onView(
                allOf(withId(R.id.depositButton),
                        isDisplayed()));
        button.check(matches(isDisplayed()));
        button.check(matches(isClickable()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.withdrawButton),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        /**
         * Check if deposit is displayed with the correct amount
         */
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.balance_item_amount), withText("$1,000.00"),
                        isDisplayed()));
        textView3.check(matches(withText("$1,000.00")));

        /**
         * Check if the list item exist
         */

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        /**
         * Withdraw test
         */
        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.check(matches(isClickable()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText3.perform(replaceText("Renovation"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText4.perform(replaceText("500"), closeSoftKeyboard());

        /**
         * Check if withdraw shows up with correct transaction
         */
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout2.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.balance_item_amount), withText("-$500.00"),
                        isDisplayed()));
        textView4.check(matches(withText("-$500.00")));

        onView(withId(R.id.balanceTextView)).check(matches(withText("$500.00")));

        /**
         * Set up a list of input
         */
        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText5.perform(replaceText("beer"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText6.perform(replaceText("200"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText7.perform(replaceText("Lottery"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText8.perform(replaceText("100000"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText9.perform(replaceText("Insurance"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText10.perform(replaceText("2000"), closeSoftKeyboard());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton5.perform(click());

        /**
         * Check if each list item exist
         */
        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        3),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.transactionsListView),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0)),
                        4),
                        isDisplayed()));
        linearLayout4.check(matches(isDisplayed()));

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
