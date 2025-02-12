import wordfrequency.WordFrequencyGame;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 2018/5/22.
 */
class WordFrequencyGameTest {
    @Test
    void should_get_the_1_when_input_the() {
        //Given
        String inputStr = "the";
        String expectResult = "the 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    void should_process_two_words() {
        //Given
        String inputStr = "the is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    void should_process_two_words_with_special_spaces() {
        //Given
        String inputStr = "the      is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    void should_process_two_words_with_special_enter() {
        //Given
        String inputStr = "the   \n   is";
        String expectResult = "the 1\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    void should_pracess_two_same_words_with_sorted() {
        //Given
        String inputStr = "the the is";
        String expectResult = "the 2\nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    void should_process_sorted_with_count_descending() {
        //Given
        String inputStr = "the is is";
        String expectResult = "is 2\nthe 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    private void validate_Input_words_process_to_expected_word(String inputStr, String expectResult) {
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertThat(result, is(expectResult));
    }
}
