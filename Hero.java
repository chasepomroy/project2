import java.util.Random;

public class Hero {
    private String heroName;
    private int heroHealth;
    private int lightAttackDamage;
    private int heavyAttackDamage;

    public Hero(){
        heroName = "";
        heroHealth = 0;
        lightAttackDamage = 0;
        heavyAttackDamage = 0;
    }

    public Hero(String heroName, int heroHealth, int lightAttackDamage, int heavyAttackDamage) {
        this.heroName = heroName;
        this.heroHealth = heroHealth;
        this.lightAttackDamage = lightAttackDamage;
        this.heavyAttackDamage = heavyAttackDamage;
    }

    public void debuggingHero(){
        System.out.println(heroName);
        System.out.println(heroHealth);
        System.out.println(lightAttackDamage);
        System.out.println(heavyAttackDamage);
    }

    public String getHeroName() { return this.heroName; }

    public void setHeroName(String name) {
        this.heroName = name;
    }

    public int getHeroHealth() {
        return this.heroHealth;
    }

    public void setHeroHealth(int heroHealth) {
        this.heroHealth = heroHealth;
    }

    public int getLightAttackDamage() {
        return this.lightAttackDamage;
    }

    public void setLightAttackDamage(int lightAttackDamage) {
        this.lightAttackDamage = lightAttackDamage;
    }

    public int getHeavyAttackDamage() {
        return this.heavyAttackDamage;
    }

    public void setHeavyAttackDamage(int heavyAttackDamage) {
        this.heavyAttackDamage = heavyAttackDamage;
    }

}
