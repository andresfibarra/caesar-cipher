public class caesarDriver {
    public static void main(String[] args) {
        String message = "This is a coded message";
        int key = 1;

        String coded = caesarEncryptor.encrypt(key, message);
        System.out.println(coded);

        String decoded = caesarEncryptor.decrypt(key, coded);
        System.out.println(decoded);

        System.out.println(caesarHacker.decode(caesarEncryptor.encrypt(1, "This is a coded message")));
        System.out.println(caesarHacker.decode(caesarEncryptor.encrypt(7, "Okay, so you expect me to believe " +
                "that you were the very best that your generation of Navy SEALs had to offer? I highly doubt that. " +
                "If you were as good as you say you were, i don't think for a second that you would be browsing reddit. " +
                "This is mostly a place for jobless neckbeards that still live with their parents, and nerdy high " +
                "school kids that don't have any friends. It really isn't the place for highly-trained assassins to be " +
                "hanging out in their spare time. Even if it was, something far worse than a troll being mean to you " +
                "probably would have set you off a long time ago. What about the slew of gore and child pornography " +
                "that gets posted here on a regular basis? Isn't that something that deserves a person being hunted " +
                "down and made to regret their actions? Yeah, you're just not the reddit type. Sure, there's a wide " +
                "variety of people that browse here, but you're far from the core demographic if you are who you say " +
                "you are (which isn't the case). Even if it were true that you're an incredibly talented soldier, I " +
                "think all the military discipline would prevent you from getting mad enough to murder some random " +
                "idiot on the internet. ")));
    }
}
