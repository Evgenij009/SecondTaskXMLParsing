package by.epam.eugene.validator;

import by.epam.eugene.validation.CustomFileValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomFileValidatorTest {
    private static final String INCORRECT_XML_FILE_PATH = "src/test/resources/test_data/tariffsInvalid.xml123";
    private static final String CORRECT_XML_FILE_PATH = "src/test/resources/test_data/tariffsValid.xml";

    @Test (groups = "Validator")
    public void testIsValidShouldReturnTrueFileIsCorrect() {
        boolean isValid;
        isValid = CustomFileValidator.isFileValid(CORRECT_XML_FILE_PATH);
        Assert.assertTrue(isValid);
    }

    @Test (groups = "Validator")
    public void testIsInvalidShouldReturnFalseFileIsCorrect() {
        boolean isValid;
        isValid = CustomFileValidator.isFileValid(INCORRECT_XML_FILE_PATH);
        Assert.assertFalse(isValid);
    }

    @Test (groups = "Validator")
    public void testIsInvalidFileisNullShouldReturnFalseFileIsCorrect() {
        boolean isValid;
        isValid = CustomFileValidator.isFileValid(null);
        Assert.assertFalse(isValid);
    }
}
