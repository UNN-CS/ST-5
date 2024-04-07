# ST-5 Модульное тестирование на Java с использованием jUnit и Maven


![GitHub pull requests](https://img.shields.io/github/issues-pr/UNN-CS/ST-5)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/UNN-CS/ST-5)

Срок выполнения задания:

**по 14.04.24** ![Relative date](https://img.shields.io/date/1713128400)



## Задание №1

В среде **Intellij Idea** создать проект **Maven** по шаблону **quickstart**. Убедиться в появлении веток `java/main` и `java/test` в разделе `src` проекта, а также файла с конфигурацией `pom.xml` в корне проекта.

Добавить в проект класс **Sqrt**, содержащий алгоритм вычисления квадратного корня методом последовательных приближений.

```java
class Sqrt
{
   double delta=0.00000001;
   double arg;

   public Sqrt(double arg) {
      this.arg=arg;
   }
   public double average(double x,double y) {
      return (x+y)/2.0;
   }
   public boolean good(double guess,double x) {
      return Math.abs(guess*guess-x)<delta;
   }
   public double improve(double guess,double x) {
      return average(guess,x/guess);
   }
   public double iter(double guess, double x) {
      if(good(guess,x))
         return guess;
      else
         return iter(improve(guess,x),x);
   }
   public double calc() {
      return iter(1.0,arg);
   }
}
```

В класс **Program** можно поместить следующий демонстрационный пример:

```java
class Program
{
   public static void main(String[] args)
   {
      double val=Double.parseDouble("2.0");
      Sqrt sqrt=new Sqrt(val);
      double result=sqrt.calc();
      System.out.println("Sqrt of " + val + " = " + result);
   }
}
```

Далее, построить проект и убедиться, что консольное приложение запускается без ошибок и выводит на экран некоторую информацию.

## Задание №2

Добавить в проект поддержку **jUnit** и поместить в соответствующий исходный файл тесты для покрытия всех методов класса **Sqrt**. провести анализ покрытия средствами **Intellij Idea**.

## Задание №3

Загрузить проект на **GitHub** и убедиться в работоспособности проектами через сценарии **GH Actions**.


