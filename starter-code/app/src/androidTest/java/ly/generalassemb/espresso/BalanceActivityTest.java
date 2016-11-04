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

    @Test // Testing View Current Balance
    public void viewCurrentBalance() {
        // Current Balance
        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView), withText("$0.00"),
                        isDisplayed()));
        textView.check(matches(withText("$0.00")));
    }

    @Test
    public void withdrawTest() {
        // Current Balance
        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView), withText("$0.00"),
                        isDisplayed()));
        textView.check(matches(withText("$0.00")));

        // OnClick New Transaction Button
        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton3.perform(click());

        // Interact with Description EditText
        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText5.perform(replaceText("withdrawTest1"), closeSoftKeyboard());

        // Interact with Amount EditText
        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText6.perform(replaceText("200"), closeSoftKeyboard());

        // OnClick Deposit Button
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton3.perform(click());

        // New Balance
        ViewInteraction textView3 = onView(
                allOf(withId(R.id.balanceTextView), withText("$200.00"),
                        isDisplayed()));
        textView3.check(matches(withText("$200.00")));
    }

    @Test
    public void depositTest() {
        // OnClick New Transaction Button
        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton3.perform(click());

        // Interact with Description EditText
        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText5.perform(replaceText("depositTest1"), closeSoftKeyboard());

        // Interact with Amount EditText
        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText6.perform(replaceText("200"), closeSoftKeyboard());

        // OnClick Deposit Button
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton3.perform(click());

        // New Balance
        ViewInteraction textView3 = onView(
                allOf(withId(R.id.balanceTextView), withText("$200.00"),
                        isDisplayed()));
        textView3.check(matches(withText("$200.00")));
    }


    @Test // Testing Multiple Withdraws and Deposits
    public void multipleTransactionsTest() {

        // Current Balance
        ViewInteraction textView = onView(
                allOf(withId(R.id.balanceTextView), withText("$0.00"),
                        isDisplayed()));
        textView.check(matches(withText("$0.00")));

        // OnClick New Transaction Button
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton.perform(click());

        // Interact with Description EditText
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText.perform(replaceText("depositTest"), closeSoftKeyboard());

        // Interact with Amount EditText
        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText2.perform(replaceText("1000"), closeSoftKeyboard());

        // OnClick Deposit Button
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton.perform(click());

        // OnClick New Transaction Button
        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton2.perform(click());

        // Interact with Description EditText
        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText3.perform(replaceText("withdrawTest"), closeSoftKeyboard());

        // Interact with Amount EditText
        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText4.perform(replaceText("100"), closeSoftKeyboard());

        // OnClick Withdraw Button
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton2.perform(click());

        // New Balance
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.balanceTextView), withText("$900.00"),
                        isDisplayed()));
        textView2.check(matches(withText("$900.00")));

        // OnClick New Transaction Button
        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton3.perform(click());

        // Interact with Description EditText
        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText5.perform(replaceText("depositTest1"), closeSoftKeyboard());

        // Interact with Amount EditText
        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText6.perform(replaceText("200"), closeSoftKeyboard());

        // OnClick Deposit Button
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.depositButton), withText("Deposit"), isDisplayed()));
        appCompatButton3.perform(click());

        // New Balance
        ViewInteraction textView3 = onView(
                allOf(withId(R.id.balanceTextView), withText("$1,100.00"),
                        isDisplayed()));
        textView3.check(matches(withText("$1,100.00")));

        // OnClick New Transaction Button
        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.newTransactionButton), isDisplayed()));
        floatingActionButton4.perform(click());

        // Interact with Description EditText
        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.descriptionEditText), isDisplayed()));
        appCompatEditText7.perform(replaceText("withdrawTest1"), closeSoftKeyboard());

        // Interact with Amount EditText
        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.amountEditText), isDisplayed()));
        appCompatEditText8.perform(replaceText("500"), closeSoftKeyboard());

        // OnClick Withdraw Button
        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.withdrawButton), withText("Withdraw"), isDisplayed()));
        appCompatButton4.perform(click());

        // New Balance
        ViewInteraction textView4 = onView(
                allOf(withId(R.id.balanceTextView), withText("$600.00"),
                        isDisplayed()));
        textView4.check(matches(withText("$600.00")));
    }
}
