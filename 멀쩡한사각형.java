import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Ex0410 {
    public long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }

    @Test
    public void 정답() {
        Assert.assertEquals(80, solution(8, 12));
        Assert.assertEquals(80, solution(12, 8));
        Assert.assertEquals(12, solution(4, 4));
    }
}

//Junit 프레임워크 활용해서 InteliJ 환경에서 작성해보았다.  lv2 기출문제
