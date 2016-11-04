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
public class BalanceActivityTest2 {

    @Rule
    public ActivityTestRule<BalanceActivity> mActivityTestRule = new ActivityTestRule<>(BalanceActivity.class);

    @Test
    public void balanceActivityTest2() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("hjkhj"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText3.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText4.perform(replaceText("jkjljkl1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText5.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText6.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.descriptionEditText), withText("1"), isDisplayed()));
        appCompatEditText7.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.descriptionEditText), withText("1"), isDisplayed()));
        appCompatEditText8.perform(replaceText("hjkhjk"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText9.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText10.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText11.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText12.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView),
                        isDisplayed()));
        textView.check(matches(withText("$1.00")));

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
