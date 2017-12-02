package year_2017.day_01

import org.scalatest.FlatSpec

class CaptchaTest extends FlatSpec {

  "The input 1122" should "return captcha 3" in {
    assert(Captcha.calculateCaptchaSumPart1("1122") == 3)
  }

  "The input 1111" should "return captcha 4" in {
    assert(Captcha.calculateCaptchaSumPart1("1111") == 4)
  }

  "The input 1234" should "return captcha 0" in {
    assert(Captcha.calculateCaptchaSumPart1("1234") == 0)
  }

  "The input 91212129" should "return captcha 9" in {
    assert(Captcha.calculateCaptchaSumPart1("91212129") == 9)
  }
  
  
  "The input 1212" should "return captcha(part 2) 6" in {
    assert(Captcha.calculateCaptchaSumPart2("1212") == 6)
  }

  "The input 1221" should "return captcha(part 2) 0" in {
    assert(Captcha.calculateCaptchaSumPart2("1221") == 0)
  }

  "The input 123425" should "return captcha(part 2) 4" in {
    assert(Captcha.calculateCaptchaSumPart2("123425") == 4)
  }

  "The input 123123" should "return captcha(part 2) 12" in {
    assert(Captcha.calculateCaptchaSumPart2("123123") == 12)
  }
  
  "The input 12131415" should "return captcha(part 2) 4" in {
    assert(Captcha.calculateCaptchaSumPart2("12131415") == 4)
  }
}