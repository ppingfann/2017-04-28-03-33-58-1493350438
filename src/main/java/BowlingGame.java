
/*@author ppingfann
 * @date 2017/5/21
 */
public class BowlingGame {
    public int[] bowlingScore = new int[10];
    public int[] bowlingnum = new int[22];
    int countnum = 0;
    
    public int getBowlingScore(String bowlingCode) {
        int sum = 0;
        char[] bowling = bowlingCode.toCharArray();
        CodeToNum(bowling);
        getScore(bowling);
        for (int i = 0; i < bowlingScore.length; i++) {
            sum += bowlingScore[i];
        }
        return sum;
    }
    
    public int CodeToNum(char[] bowling) {
        int j = 0;
        for (int i = 0; i <bowling.length ; i++) {

            switch (bowling[i]) {
                case 'X':
                    bowlingnum[j] = 10;
                    j++;
                    continue;
                case '/':
                    bowlingnum[j] = 10 - bowlingnum[j - 1];
                    j++;
                    continue;
                case '-':
                    bowlingnum[j] = 0;
                    j++;
                    continue;
                case '|':
                    countnum++;
                    continue;
                default:
                    bowlingnum[j] = bowling[i] - '0';
                    j++;
                    continue;
            }
        }
        return 0;
    }

    public void getScore(char[] bowling) {
        int j = 0;
        int count = 0;
        int midScore = 0;
        for (int i = 0; i <bowling.length; i++) {
            if (bowling[i] != '|') {
                switch (bowling[i]) {
                    case 'X':
                        midScore = 10 + bowlingnum[i - count + 1] + bowlingnum[i - count + 2];
                        continue;
                    case '/':
                        midScore = 10 + bowlingnum[i - count + 1];
                        continue;
                    default:
                        midScore += bowlingnum[i - count];
                        continue;
                }
            }
            else {
                count++;
            }
            bowlingScore[j] = midScore;
            midScore = 0;
            j++;
            if (j == 10)
            break;
        }
    }
}
