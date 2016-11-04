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
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
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
    public void balanceIsViewableTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView), withText("$0.00"),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));
    }

    @Test
    public void chainedTransactionsTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("4865.00"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText3.perform(replaceText("d"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText4.perform(replaceText("3456"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.balance_item_amount), withText("$4,865.00"),
                        isDisplayed()));
        textView.check(matches(withText("$4,865.00")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.balance_item_amount), withText("-$3,456.00"),
                        isDisplayed()));
        textView2.check(matches(withText("-$3,456.00")));
    }

    @Test
    public void pastTransactionsDisplayedTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("4865.00"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText3.perform(replaceText("d"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText4.perform(replaceText("3456"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.balance_item_amount), withText("$4,865.00"),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.balance_item_amount), withText("-$3,456.00"),
                        isDisplayed()));
        textView4.check(matches(isDisplayed()));
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
