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
public class BalanceActivityTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mActivityTestRule = new ActivityTestRule<>(BalanceActivity.class);

    @Test
    public void balanceActivityTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView), withText("$0.00"),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

    }


    @Test
    public void balanceActivityDepositTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("Test"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView), withText("$5.00"),
                        isDisplayed()));
        textView.check(matches(withText("$5.00")));

    }




    @Test
    public void balanceActivityWithdrawTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("Withdraw"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView), withText("-$5.00"),
                        childAtPosition(
                                allOf(withId(R.id.balanceRelativeLayout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("-$5.00")));

    }




    @Test
    public void balanceActivityMultipleTransactionsTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("Student Loan"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("13000"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText3.perform(replaceText("Beer"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText4.perform(replaceText("40"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText5.perform(replaceText("Wine"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText6.perform(replaceText("18"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText7.perform(replaceText("Keg"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText8.perform(replaceText("120"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText9.perform(replaceText("Atlantic City Trip"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText10.perform(replaceText("1400"), closeSoftKeyboard());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction floatingActionButton6 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton6.perform(click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText11.perform(replaceText("Nutella"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText12.perform(replaceText("500"), closeSoftKeyboard());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction floatingActionButton7 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton7.perform(click());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText13.perform(replaceText("Bathtub"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText15.perform(replaceText("700"), closeSoftKeyboard());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction floatingActionButton8 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton8.perform(click());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText16.perform(replaceText("Red Camera"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText17.perform(replaceText("6000"), closeSoftKeyboard());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction floatingActionButton9 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton9.perform(click());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText18.perform(replaceText("More Beer"), closeSoftKeyboard());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText19.perform(replaceText("4000"), closeSoftKeyboard());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction floatingActionButton10 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton10.perform(click());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText20.perform(replaceText("Keg Security Deposit"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText21.perform(replaceText("200"), closeSoftKeyboard());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction floatingActionButton11 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton11.perform(click());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText22.perform(replaceText("Textbook"), closeSoftKeyboard());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText23.perform(replaceText("21"), closeSoftKeyboard());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction floatingActionButton12 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton12.perform(click());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText24.perform(replaceText("McChicken"), closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText25.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton12.perform(click());


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
