import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Это тестовый framework. Здесь перестаем работать с методом main. Их практически уже не будет. Дальше будут тесты,
 * а пока работаем как программисты.
 * Тесты пишутся всегда с аннотации @Test. Как только нажали enter на подсказку, наверх импортируется эта аннотация из
 * библиотеки TestInjin. Пока не пропишем тест аннотация будет подчеркиваться красным. Тесты всегда!!!! public void
 * и они всегда!!!! начинаются со слова test дальнейшие слова должны описывать суть и смысл теста.
 * В unit тестах есть особенность: они должны тестировать каждую строчку кода, каждое условие (сначала тестируем то, что
 * должно делаться для валидных значений - happy path, и, если все OK, то берем какое-то невалидное значение, чтобы
 * вернулся пустой массив).
 * Первое, что делаю, - копирую первое условие и вставляю в тест
 * Самое большое кол-во тестов - это unit tests. Эти тесты должны каждую строчку условия кода протестировать, чтобы
 * каждое разделение в ветках сценария было протестировано отдельным независимым тестом.
 */
public class FizzBuzzTest {
    /* 1. Positive testing Happy path
     *  if (start <= end)
     * return array;
     */

    //start < end
    @Test
    public void testStartLessThanEnd_HappyPath() { //Тесты всегда без параметров!!!!
        //AAA
        //arrange - устанавливаю все условия. Идем в метод и
        // копируем все параметры - public String[] fizzBuzz(int start, int end) - start и end, чтобы не забыть
        int start = 1; // 1 и 20 мы их держали в голове, пока писали метод и формулу
        int end = 20;
        String[] expectedResult = {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz"}; //expectedResult мы должны высчитать
        // или скопировать с требований. Метод должен вернуть String (прописываем)

        //act
        /* На других потоках делали так: создавали объект класса, получали:
        * FizzBuzz fizzBuzz = new FizzBuzz();
        * где FizzBuzz - тип данных, fizzBuzz -переменная. Через слово new, используя Java конструктор по умолчанию
        * (в скобках () нет никаких параметров), создали объект класса
         */

        /* на этом потоке будем так:
        * будем сразу, после знака =, создавать объект класса, в котором лежит наш метод. И от объекта этого класса
        * (ставим ТОЧКУ) выбираем/вызываем метод fizzBuzz(), выбираем два параметра(start, end).
         */

        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);//по объектно ориентированному программированию
        //нужно создать объект класса, чтобы от него вызвать метод

        //Assert
        /* Вызываем класс Assert - это встроенный testng (тестинжин) (testng - надстройка над JUnit, который тоже
        * встроен), нажимаем точку, выбираем любой assertEquals (методы в тестовом фрэймворке,
        * называются assertEquals), вставляем actualResult, expectedResult
         */

        Assert.assertEquals(actualResult, expectedResult);
    }

    //start == end            копируем первый и вносим изменения
    @Test
    public void testStartEqualsEnd_HappyPath() {
        //AAA
        //arrange

        int start = 1;
        int end = 1;
        String[] expectedResult = {"1"};
        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }

    //start < end
    @Test
    public void testStartLessThanEnd_StartEndAreNegative_HappyPath() {
        //AAA
        //arrange
        int start = -20;
        int end = -1;
        String[] expectedResult = {"Buzz", "-19", "Fizz", "-17", "-16", "FizzBuzz", "-14", "-13", "Fizz", "-11", "Buzz",
                "Fizz", "-8", "-7", "Fizz", "Buzz", "-4", "Fizz", "-2", "-1"};

        //act
        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }

    /*
     * Так как все позитивные условия проверили, то можно
     * 2. Negative testing
     * if (start > end)
     * return new String[0]; должен сформироваться пустой массив
     */

    @Test
    public void testStartGreaterThanEnd_Negative() {
        //AAA
        //arrange
        int start = 20;
        int end = 1;
        String[] expectedResult = {};//должен сформироваться пустой массив

        //act
        String[] actualResult = new FizzBuzz().fizzBuzz(start, end);

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
}
