public class CaesarCipher {
    public static String encryptCaesarCipher(String plaintext, int offset)
    {
        if(offset >= 26 || offset <= -26)
        {
            offset = offset % 26;
        }

        if(offset == 0)
        {
            return plaintext;
        }

        String s = ""; //���ϰ� ��ȯ�� ���� ����
        char ch; //newChNum�� s�� �����ϱ� ���� ����
        int chNum; //���ڿ��� ���ڸ� �ޱ� ���� ����
        int newChNum;//chNum ��ȯ���� ����

        for(int i = 0; i < plaintext.length(); i++)
        {
            if(plaintext.charAt(i) != 32 && plaintext.charAt(i) !=9) //����� �鿩���� ����
            {
                chNum = plaintext.charAt(i);
                newChNum = chNum + offset;

                if(newChNum > 126)
                {
                    newChNum -= 93;
                }

                if(newChNum < 33)
                {
                    newChNum += 93;
                }
                ch = (char)newChNum;

                s += ch;
            }
            else
            {
            	if(plaintext.charAt(i) == 32)
            		s += " ";
            	else
            		s +="	";
            }
        }
        return s;
    }
}


