import a11908284.AttackingSpell;
import a11908284.Concoction;
import a11908284.HealingSpell;
import a11908284.HealthPotion;
import a11908284.MagicLevel;
import a11908284.ManaPotion;
import a11908284.Potion;
import a11908284.ProtectingSpell;
import a11908284.Scroll;
import a11908284.Spell;
import a11908284.Tradeable;
import a11908284.Wizard;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tester
{
	//if there are no colors in your console but instead weird symbols change all of these strings to "" (empty)
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public static boolean validTest = true;
	public static boolean totalTest = true;

	public static void pass()
	{
		System.out.println(ANSI_GREEN + "[OK]" + ANSI_RESET);
	}

	public static void fail()
	{
		System.out.println(ANSI_RED + "[FAILED]" + ANSI_RESET);
		validTest = false;
		totalTest = false;
	}

	public static void throwing()
	{
		System.out.println(ANSI_RED + "[THROW]" + ANSI_RESET);
		validTest = false;
		totalTest = false;
	}

	public static void main(String[] args)
	{
		// "global" data, do not change these!

		MagicLevel noobLevel = MagicLevel.NOOB;
		MagicLevel adeptLevel = MagicLevel.ADEPT;
		MagicLevel studentLevel = MagicLevel.STUDENT;
		MagicLevel expertLevel = MagicLevel.EXPERT;
		MagicLevel masterLevel = MagicLevel.MASTER;

		Spell basicPercHealingHP10 = new HealingSpell("basic%HPHeal", 1, noobLevel, true, true, 10);
		Spell basicPercHealingMP10 = new HealingSpell("basic%MPHeal", 1, noobLevel, false, true, 10);
		AttackingSpell basicPercAttackHP10 = new AttackingSpell("basic%DamageHP", 1, noobLevel, true, true, 10);
		AttackingSpell basicPercAttackMP10 = new AttackingSpell("basic%DamageMP", 1, noobLevel, false, true, 10);
		Set<Spell> basicSpells = new HashSet<>();
		basicSpells.add(basicPercHealingHP10);
		basicSpells.add(basicPercHealingMP10);
		basicSpells.add(basicPercAttackHP10);
		basicSpells.add(basicPercAttackMP10);

		AttackingSpell advancedAttack = new AttackingSpell("basic%DamageHP", 1, studentLevel, true, true, 10);
		AttackingSpell advancedAttack2 = new AttackingSpell("basic%DamageHP", 1, expertLevel, true, true, 10);
		Set<Spell> advancedSpells = new HashSet<>();
		basicSpells.add(advancedAttack);
		basicSpells.add(advancedAttack2);

		List<Spell> basicSpellList = new ArrayList<Spell>();
		basicSpellList.add(basicPercHealingHP10);
		basicSpellList.add(basicPercHealingMP10);
		basicSpellList.add(basicPercAttackHP10);
		basicSpellList.add(basicPercAttackMP10);

		Spell simpleSpell = new HealingSpell("simple", 10, noobLevel, true, false, 10);
		List<Spell> simpleSpellList = new ArrayList<Spell>();
		simpleSpellList.add(simpleSpell);

		Spell simpleSpell2 = new HealingSpell("simple2", 10, adeptLevel, false, false, 20);
		List<Spell> advancedSpellList = new ArrayList<Spell>();
		advancedSpellList.add(simpleSpell);
		advancedSpellList.add(simpleSpell2);

		List<Spell> emptySpellList = new ArrayList<Spell>();

		Potion basicHPPotion = new HealthPotion("basicHPPotion", 10, 5, 10, 100);
		Potion basicMPPotion = new ManaPotion("basicMPPotion", 10, 1, 10, 100);
		// weight is 20
		Set<Tradeable> basicInventory = new HashSet<>();
		basicInventory.add(basicHPPotion);
		basicInventory.add(basicMPPotion);

		Set<AttackingSpell> basicProtection = new HashSet<>();
		basicProtection.add(basicPercAttackHP10);
		basicProtection.add(basicPercAttackMP10);

		Set<AttackingSpell> simpleProtection = new HashSet<>();
		simpleProtection.add(basicPercAttackMP10);

		Set<Spell> noSpells = new HashSet<>();
		Set<AttackingSpell> noProtection = new HashSet<>();
		Set<Tradeable> noInventory = new HashSet<>();

		Potion miscItem = new HealthPotion("miscItem", 10, 10, 100, 100);

		Set<Tradeable> smallInventory = new HashSet<>();
		smallInventory.add(basicHPPotion);

		// #######################################################################################################################################
		System.out.println("Hogwarts Legacy PROG2 Unit Test: \n");
		// #######################################################################################################################################
		System.out.println("Class HealthPotion: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test HealthPotion constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "name null: ");
		try
		{
			@SuppressWarnings("unused")
			HealthPotion potion = new HealthPotion(null, 10, 10, 10, 10);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "name emtpy: ");
		try
		{
			@SuppressWarnings("unused")
			HealthPotion potion = new HealthPotion("", 10, 10, 10, 10);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative usages: ");
		try
		{
			@SuppressWarnings("unused")
			HealthPotion potion = new HealthPotion("potion", -10, 10, 10, 10);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative price: ");
		try
		{
			@SuppressWarnings("unused")
			HealthPotion potion = new HealthPotion("potion", 10, -10, 10, 10);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================

		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative weight: ");
		try
		{
			@SuppressWarnings("unused")
			HealthPotion potion = new HealthPotion("potion", 10, 10, -10, 10);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================

		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative health: ");
		try
		{
			@SuppressWarnings("unused")
			HealthPotion potion = new HealthPotion("potion", 10, 10, 10, -10);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test HealthPotion additionalOutputString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/10/10 potion: ");
		try
		{
			HealthPotion potion = new HealthPotion("potion", 10, 10, 10, 10);
			System.out.println("; +10 HP");
			System.out.println(potion.additionalOutputString());
			if (potion.additionalOutputString().equals("; +10 HP"))
				pass();
			else
			{
				fail();
			}
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test HealthPotion useOn(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not used: ");
		try
		{
			HealthPotion potion = new HealthPotion("potion", 10, 10, 10, 10);
			if (potion.getUsages() == 10)
				pass();
			else
				fail();

			// =======================================================================================================================================
			System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "-1 usage: ");
			// damaged wizard
			Wizard wizard = new Wizard("w", noobLevel, 100, 50, 200, 200, 100, basicSpells, basicProtection, 1000, basicInventory);
			potion.useOn(wizard);

			if (potion.getUsages() == 9)
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "null uses: ");
		try
		{
			HealthPotion potion = new HealthPotion("potion", 10, 10, 10, 10);
			System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "-1 usage: ");
			potion.useOn(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test HealthPotion usageString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10 usage: ");
		try
		{
			HealthPotion potion = new HealthPotion("potion", 10, 10, 10, 10);
			if (potion.usageString().equals("gulps"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "1 usage: ");
		try
		{
			HealthPotion potion = new HealthPotion("potion", 1, 10, 10, 10);
			if (potion.usageString().equals("gulp"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "drinking : ");
		try
		{
			HealthPotion potion = new HealthPotion("potion", 1, 10, 10, 10);
			Wizard wizard = new Wizard("W", adeptLevel, 100, 50, 400, 400, 100, noSpells, noProtection, 100, noInventory);

			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			String compString = new String("[W(**): 50/100 400/400; 100 Knuts; knows []; carries []]");
			System.out.println(compString);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals(compString))
				fail();

			potion.drink(wizard);

			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			compString = new String("[W(**): 60/100 400/400; 100 Knuts; knows []; carries []]");
			System.out.println(wizard.toString());
			System.out.println(compString);
			if (wizard.toString().equals(compString))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		System.out.println("Class ManaPotion: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test ManaPotion constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative mana: ");
		try
		{
			@SuppressWarnings("unused")
			ManaPotion potion = new ManaPotion("potion", 10, 10, 10, -10);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		// SuperClass is already tested with HealtPotion
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test ManaPotion additionalOutputString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/10/10 potion: ");
		try
		{
			ManaPotion potion = new ManaPotion("potion", 10, 10, 10, 10);
			System.out.println("; +10 MP");
			System.out.println(potion.additionalOutputString());
			if (potion.additionalOutputString().equals("; +10 MP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test ManaPotion useOn(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not used: ");
		try
		{
			ManaPotion potion = new ManaPotion("potion", 10, 10, 10, 10);
			if (potion.getUsages() == 10)
				pass();
			else
				fail();

			// =======================================================================================================================================
			System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "-1 usage: ");
			// damaged wizard
			Wizard wizard = new Wizard("w", noobLevel, 50, 100, 200, 200, 100, basicSpells, basicProtection, 1000, basicInventory);
			potion.useOn(wizard);

			if (potion.getUsages() == 9)
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "use on null: ");
		try
		{
			ManaPotion potion = new ManaPotion("potion", 10, 10, 10, 10);
			potion.useOn(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		System.out.println("Class Concoction: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Concoction constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "is null: ");
		try
		{
			@SuppressWarnings("unused")
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 10, 10, null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "HP = MP = spells = 0: ");
		try
		{
			@SuppressWarnings("unused")
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 0, 0, emptySpellList);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "HP = MP = 0: ");
		try
		{
			@SuppressWarnings("unused")
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 0, 0, simpleSpellList);
			pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Concoction additionalOutputString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/10/10/spell concoction: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 10, 10, simpleSpellList);
			// : != ; !!!
			System.out.println("; +10 HP; +10 MP; cast [[simple(*): 10 mana; +10 HP]]");
			System.out.println(concoction.additionalOutputString());
			if (concoction.additionalOutputString().equals("; +10 HP; +10 MP; cast [[simple(*): 10 mana; +10 HP]]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/10/10/empty spell concoction: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 10, 10, emptySpellList);
			// check spaces!
			System.out.println("; +10 HP; +10 MP");
			System.out.println(concoction.additionalOutputString());
			if (concoction.additionalOutputString().equals("; +10 HP; +10 MP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/no health/10/empty spell concoction: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 0, 10, emptySpellList);
			// check spaces!
			System.out.println("; +10 MP");
			System.out.println(concoction.additionalOutputString());
			if (concoction.additionalOutputString().equals("; +10 MP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/10/no mana/empty spell concoction: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 10, 0, emptySpellList);
			// check spaces!
			System.out.println("; +10 HP");
			System.out.println(concoction.additionalOutputString());
			if (concoction.additionalOutputString().equals("; +10 HP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/no health/10/spell concoction: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 0, 10, simpleSpellList);
			// check spaces!
			System.out.println("; +10 MP; cast [[simple(*): 10 mana; +10 HP]]");
			System.out.println(concoction.additionalOutputString());
			if (concoction.additionalOutputString().equals("; +10 MP; cast [[simple(*): 10 mana; +10 HP]]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/10/no mana/spell concoction: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 10, 0, simpleSpellList);
			// check spaces!
			System.out.println("; +10 HP; cast [[simple(*): 10 mana; +10 HP]]");
			System.out.println(concoction.additionalOutputString());
			if (concoction.additionalOutputString().equals("; +10 HP; cast [[simple(*): 10 mana; +10 HP]]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "10/10/100/100/advanced spellList: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 100, 100, advancedSpellList);
			// check spaces!
			System.out.println("; +100 HP; +100 MP; cast [[simple(*): 10 mana; +10 HP], [simple2(**): 10 mana; +20 MP]]");
			System.out.println(concoction.additionalOutputString());
			if (concoction.additionalOutputString().equals("; +100 HP; +100 MP; cast [[simple(*): 10 mana; +10 HP], [simple2(**): 10 mana; +20 MP]]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "use on: ");
		try
		{
			Concoction concoction = new Concoction("concotion", 10, 10, 10, 10, 10, simpleSpellList);
			// damaged, oom Wizard
			Wizard wizard = new Wizard("w", noobLevel, 100, 50, 200, 0, 100, basicSpells, noProtection, 1000, basicInventory);
			concoction.useOn(wizard);
			pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		System.out.println("Class AttackingSpell: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test AttackSpell constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "null name: ");
		try
		{
			@SuppressWarnings("unused")
			AttackingSpell attackSpell = new AttackingSpell(null, 10, noobLevel, true, true, 90);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "empty name: ");
		try
		{
			@SuppressWarnings("unused")
			AttackingSpell attackSpell = new AttackingSpell("", 10, noobLevel, true, true, 90);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative cost: ");
		try
		{
			@SuppressWarnings("unused")
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", -10, noobLevel, true, true, 90);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "null level: ");
		try
		{
			@SuppressWarnings("unused")
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, null, true, true, 90);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative amount: ");
		try
		{
			@SuppressWarnings("unused")
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, true, true, -90);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "amount out of range: ");
		try
		{
			@SuppressWarnings("unused")
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, true, true, 101);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "amount valid value: ");
		try
		{
			@SuppressWarnings("unused")
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, true, false, 101);
			pass();
		}
		catch (IllegalArgumentException e)
		{
			fail();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test AttackSpell doEffect(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "do null: ");
		try
		{
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, true, false, 101);
			attackSpell.doEffect(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "doEffect: ");
		try
		{
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, true, false, 101);
			// tank wizard
			Wizard wizard = new Wizard("w", noobLevel, 1000, 500, 200, 0, 100, basicSpells, noProtection, 1000, basicInventory);
			attackSpell.doEffect(wizard);
			pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test AttackSpell additionalOutputString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "raw health: ");
		try
		{
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, true, false, 101);
			System.out.println("; -101 HP");
			System.out.println(attackSpell.additionalOutputString());
			if (attackSpell.additionalOutputString().equals("; -101 HP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "raw mana: ");
		try
		{
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, false, false, 101);
			System.out.println("; -101 MP");
			System.out.println(attackSpell.additionalOutputString());
			if (attackSpell.additionalOutputString().equals("; -101 MP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "% health: ");
		try
		{
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, true, true, 60);
			System.out.println("; -60 % HP");
			System.out.println(attackSpell.additionalOutputString());
			if (attackSpell.additionalOutputString().equals("; -60 % HP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "% mana: ");
		try
		{
			AttackingSpell attackSpell = new AttackingSpell("attackSpell", 10, noobLevel, false, true, 40);
			System.out.println("; -40 % MP");
			System.out.println(attackSpell.additionalOutputString());
			if (attackSpell.additionalOutputString().equals("; -40 % MP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		System.out.println("Class HealingSpell: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test HealingSpell constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		// super class is already tested with AttackSpell
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative amount: ");
		try
		{
			@SuppressWarnings("unused")
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, true, true, -90);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "amount out of range: ");
		try
		{
			@SuppressWarnings("unused")
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, true, true, 101);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "amount valid value: ");
		try
		{
			@SuppressWarnings("unused")
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, true, false, 101);
			pass();
		}
		catch (IllegalArgumentException e)
		{
			fail();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test HealingSpell doEffect(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "do null: ");
		try
		{
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, true, false, 101);
			healingSpell.doEffect(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "doEffect: ");
		try
		{
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, true, false, 101);
			// tank wizard
			Wizard wizard = new Wizard("w", noobLevel, 1000, 500, 200, 0, 100, basicSpells, noProtection, 1000, basicInventory);
			healingSpell.doEffect(wizard);
			pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test HealingSpell additionalOutputString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "raw health: ");
		try
		{
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, true, false, 101);
			System.out.println("; +101 HP");
			System.out.println(healingSpell.additionalOutputString());
			if (healingSpell.additionalOutputString().equals("; +101 HP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "raw mana: ");
		try
		{
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, false, false, 101);
			System.out.println("; +101 MP");
			System.out.println(healingSpell.additionalOutputString());
			if (healingSpell.additionalOutputString().equals("; +101 MP"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "% health: ");
		try
		{
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, true, true, 60);
			String compString = new String("; +60 % HP");
			System.out.println(compString);
			System.out.println(healingSpell.additionalOutputString());
			if (healingSpell.additionalOutputString().equals(compString))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "% mana: ");
		try
		{
			HealingSpell healingSpell = new HealingSpell("healingSpell", 10, noobLevel, false, true, 40);
			String compString = new String("; +40 % MP");
			System.out.println(compString);
			System.out.println(healingSpell.additionalOutputString());
			if (healingSpell.additionalOutputString().equals(compString))
				pass();
			else
			{
				fail();

			}
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		System.out.println("Class ProtectingSpell: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test ProtectingSpell constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "attacks null: ");
		try
		{
			@SuppressWarnings("unused")
			ProtectingSpell protSpell = new ProtectingSpell("protSpell", 100, noobLevel, null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "attacks empty: ");
		try
		{
			Set<AttackingSpell> emptySpells = new HashSet<>();
			@SuppressWarnings("unused")
			ProtectingSpell protSpell = new ProtectingSpell("protSpell", 100, noobLevel, emptySpells);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test ProtectingSpell doEffect(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "do null: ");
		try
		{
			Wizard wizard = new Wizard("w", noobLevel, 1000, 500, 200, 0, 100, basicSpells, noProtection, 1000, basicInventory);
			if (wizard.isProtected(null))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "doEffect: ");
		try
		{
			Set<AttackingSpell> defenseList = new HashSet<>();
			defenseList.add(basicPercAttackHP10);
			ProtectingSpell protSpell = new ProtectingSpell("protSpell", 100, noobLevel, defenseList);
			// tank wizard
			Wizard wizard = new Wizard("w", noobLevel, 1000, 500, 200, 0, 100, basicSpells, noProtection, 1000, basicInventory);
			// wizard can't be protected at this point
			if (wizard.isProtected(basicPercAttackHP10))
			{
				fail();

			}
			protSpell.doEffect(wizard);
			if (wizard.isProtected(basicPercAttackHP10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test ProtectingSpell additionalOutputString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "spell list: ");
		try
		{
			AttackingSpell spell = new AttackingSpell("bolt", 10, noobLevel, true, false, 10);
			AttackingSpell spell1 = new AttackingSpell("flame", 100, adeptLevel, false, true, 10);
			Set<AttackingSpell> defenseList = new HashSet<>();
			defenseList.add(spell);
			defenseList.add(spell1);
			ProtectingSpell protSpell = new ProtectingSpell("protSpell", 100, noobLevel, defenseList);

			String compString = new String("; protects against [[flame(**): 100 mana; -10 % MP], [bolt(*): 10 mana; -10 HP]]");
			String compString2 = new String("; protects against [[bolt(*): 10 mana; -10 HP], [flame(**): 100 mana; -10 % MP]]");
			System.out.println("Order changes depending on system");
			System.out.println(compString);
			System.out.println(protSpell.additionalOutputString());
			if (protSpell.additionalOutputString().equals(compString) || protSpell.additionalOutputString().equals(compString2))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		System.out.println("Class Scroll: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Scroll constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		// super class tested with HealthPotion
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "spell null: ");
		try
		{
			@SuppressWarnings("unused") // Scroll(String name, int usages, int price, int weight, Spell spell)
			Scroll scroll = new Scroll("scroll", 10, 100, 100, null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Scroll additionalOutputString(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "spell s: ");
		try
		{
			AttackingSpell spell = new AttackingSpell("bolt", 10, noobLevel, true, false, 10);
			Scroll scroll = new Scroll("scroll", 10, 100, 100, spell);
			String compString = new String("; casts [bolt(*): 10 mana; -10 HP]");
			System.out.println(compString);
			System.out.println(scroll.additionalOutputString());
			if (scroll.additionalOutputString().equals(compString))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Scroll useOn(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not used: ");
		try
		{
			AttackingSpell spell = new AttackingSpell("bolt", 10, noobLevel, true, false, 10);
			Scroll scroll = new Scroll("scroll", 10, 100, 100, spell);
			scroll.useOn(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not used: ");
		try
		{
			AttackingSpell spell = new AttackingSpell("bolt", 10, noobLevel, true, false, 10);
			Scroll scroll = new Scroll("scroll", 10, 100, 100, spell);
			if (scroll.getUsages() == 10)
				pass();
			else
				fail();
			// =======================================================================================================================================
			System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "-1 usage: ");
			// damaged wizard
			Wizard wizard = new Wizard("w", noobLevel, 100, 50, 200, 200, 100, basicSpells, basicProtection, 1000, basicInventory);
			scroll.useOn(wizard);

			if (scroll.getUsages() == 9)
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		System.out.println("Class Wizard: \n");
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard constructor: " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "name null: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardNameNull = new Wizard(null, adeptLevel, 100, 100, 200, 200, 1000, basicSpells, basicProtection, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "name empty: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardNameNull = new Wizard("", adeptLevel, 100, 100, 200, 200, 1000, basicSpells, basicProtection, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "level null: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardLevel = new Wizard("W", null, 100, 100, 200, 200, 1000, basicSpells, basicProtection, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "basicHp negative: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardBasicHP = new Wizard("W", adeptLevel, -100, 100, 200, 200, 1000, basicSpells, basicProtection, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "HP negative: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardHP = new Wizard("W", adeptLevel, 100, -100, 200, 200, 1000, basicSpells, basicProtection, 13000, basicInventory);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "basicMP < levelMP: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardBasicMP = new Wizard("W", adeptLevel, 100, 100, 90, 200, 1000, basicSpells, basicProtection, 13000, basicInventory);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative MP: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardMP = new Wizard("W", adeptLevel, 100, 100, 1500, -200, 1000, basicSpells, basicProtection, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative money: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardMoney = new Wizard("W", adeptLevel, 100, 100, 1500, 200, -10, basicSpells, basicProtection, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "known spells null: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardKnownSpells = new Wizard("W", adeptLevel, 100, 100, 1500, 200, 10, null, basicProtection, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "protected from null: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardProtectedFrom = new Wizard("W", adeptLevel, 100, 100, 1500, 200, 10, basicSpells, null, 13000, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "carrying capacity negative: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardCarryingCapacity = new Wizard("W", adeptLevel, 100, 100, 1500, 200, 10, basicSpells, basicProtection, -130, basicInventory);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "inventory null: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardInventory = new Wizard("W", adeptLevel, 100, 100, 1500, 200, 10, basicSpells, basicProtection, 13000, null);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid values: ");
		try
		{
			@SuppressWarnings("unused")
			Wizard wizardTotalInventory = new Wizard("W", adeptLevel, 100, 100, 200, 200, 10, basicSpells, basicProtection, 100, basicInventory);
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		finally
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test wizard.isDead(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "alive wizard: ");
		try
		{
			Wizard wizard = new Wizard("wizard_alive", adeptLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.isDead())
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("wizard_dead", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);

			if (wizard.isDead())
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
//		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		// uncomment for private function, make function public for testing
//		System.out.println(ANSI_CYAN + "Test Wizard.inventoryTotalWeight(): " + ANSI_RESET);
//		// =======================================================================================================================================
//		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "basicInventory: ");
//		try
//		{
//			Wizard wizard = new Wizard("wizard_dead", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
//
//			if (wizard.inventoryTotalWeight() == 20)
//				pass();
//			else
//				fail();
//		}
//		catch (IllegalArgumentException e)
//		{
//			throwing();	
//		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.learn(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "spell is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			wizard.learn(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			;
			if (wizard.learn(simpleSpell))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "known spell");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			;
			if (wizard.learn(basicPercHealingHP10))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "unknown spell");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.learn(simpleSpell))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.forget(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "spell is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			wizard.forget(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.forget(simpleSpell))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "unknown spell");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			;
			if (wizard.forget(simpleSpell))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "known spell");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.forget(basicPercHealingHP10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.castSpell(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "spell is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			wizard.castSpell(null, wizard1);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "target is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			wizard.castSpell(simpleSpell, null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "unknown spell");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.castSpell(simpleSpell, wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid spell");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.castSpell(basicPercHealingHP10, wizard1))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "noob wizard");
		try
		{
			Wizard wizard = new Wizard("W", noobLevel, 100, 10, 1000, 1000, 1000, advancedSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", noobLevel, 100, 100, 1000, 1000, 1000, advancedSpells, basicProtection, 100, basicInventory);
			if (wizard.castSpell(basicPercHealingHP10, wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.randomSpell(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "knows no spells: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.castRandomSpell(wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "knows spells:");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			// careful, wizard can know spells that it cannot cast, set level to masterLevel
			if (wizard.castRandomSpell(wizard1))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.useItem(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "item is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			wizard.useItem(null, wizard);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "target is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			wizard.useItem(basicHPPotion, null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.useItem(basicHPPotion, wizard))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "does not have item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.useItem(miscItem, wizard))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid use: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.useItem(basicHPPotion, wizard))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.useRandomItem(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "no inventory: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);

			if (wizard.useRandomItem(wizard))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid use: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.useRandomItem(wizard))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "target null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.useRandomItem(null))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.sellItem(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "item is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			wizard.sellItem(null, wizard1);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "target is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			wizard.sellItem(basicHPPotion, null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			if (wizard.sellItem(basicHPPotion, wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid trade: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			if (wizard.sellItem(basicHPPotion, wizard1))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.sellRandomItem(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "no inventory: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			if (wizard.sellItem(basicHPPotion, wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid random trade: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			if (wizard.sellRandomItem(wizard1))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "trade null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.sellRandomItem(null))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard toString: " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "filled in knuts: ");
		try
		{
			Wizard wizard = new Wizard("Wizard0", adeptLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			System.out.println(ANSI_YELLOW + "wizard0" + ANSI_RESET);
			System.out.println(wizard.toString());
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "filled in knut: ");
		try
		{
			Wizard wizard = new Wizard("Wizard0", adeptLevel, 100, 100, 1000, 1000, 1, basicSpells, basicProtection, 100, basicInventory);
			System.out.println(ANSI_YELLOW + "wizard0" + ANSI_RESET);
			System.out.println(wizard.toString());
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
//		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "no HP/MP: ");
//		try
//		{
//			Wizard wizard = new Wizard("Wizard1", adeptLevel, 100, 200, 1000, basicSpells, basicProtection, 100, basicInventory);
//			System.out.println(ANSI_YELLOW + "wizard1" + ANSI_RESET);
//			System.out.println(wizard.toString());
//		}
//		catch (IllegalArgumentException e)
//		{
//			throwing();
//		}

		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "no spells: ");
		try
		{
			Wizard wizard = new Wizard("Wizard2", adeptLevel, 100, 100, 1000, 1000, 1000, noSpells, basicProtection, 100, basicInventory);
			System.out.println(ANSI_YELLOW + "wizard2" + ANSI_RESET);
			System.out.println(wizard.toString());
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		// TODO make sure we really do not need to print 'protected from' in wizard
		// class
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not protected: ");
		try
		{
			Wizard wizard = new Wizard("Wizard3", adeptLevel, 100, 100, 1000, 1000, 1000, basicSpells, noProtection, 100, basicInventory);
			System.out.println(ANSI_YELLOW + "wizard3" + ANSI_RESET);
			System.out.println(wizard.toString());
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not inventory: ");
		try
		{
			Wizard wizard = new Wizard("Wizard4", adeptLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			System.out.println(ANSI_YELLOW + "wizard4" + ANSI_RESET);
			System.out.println(wizard.toString());
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.provideMana(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "level is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.provideMana(null, 10))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "mana is negative: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.provideMana(noobLevel, -10))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.provideMana(noobLevel, 10))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "noob wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", adeptLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.provideMana(masterLevel, 10))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "oom wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 5, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.provideMana(noobLevel, 10))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.provideMana(noobLevel, 10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.posesses(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "null item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 5, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.possesses(null))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "random item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 5, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.possesses(miscItem))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "owns item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.possesses(basicMPPotion))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.canAfford(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative ammount: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 5, 500, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.canAfford(-10))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "poor wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 5, 10, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.canAfford(100))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "rich wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.canAfford(1000))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.hasCapacity(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative capacity");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 5, 10, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.hasCapacity(-10))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "I'm not a beast of burden: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 5, 10, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.hasCapacity(1000))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "space in inventory: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			// basic inventory is 20 weight
			if (wizard.hasCapacity(80))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.pay(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.pay(-10))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.pay(1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "poor wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 10, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.pay(11))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "rich wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.pay(1000))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.earn(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative earn: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.earn(-10))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.earn(1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();

		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid earn: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, basicInventory);
			if (wizard.earn(1000))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.addToInventory(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "item null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			if (wizard.addToInventory(null))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "add too heavy item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			if (wizard.addToInventory(miscItem))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "add item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 120, basicInventory);
			if (wizard.addToInventory(miscItem))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.removeFromInventory(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "remove null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			if (wizard.removeFromInventory(null))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "doesn't own item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			if (wizard.removeFromInventory(miscItem))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "owns item: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 120, basicInventory);
			if (wizard.removeFromInventory(basicHPPotion))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.canSteal(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard canSteal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			if (wizard.canSteal())
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "alive wizard canSteal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			if (wizard.canSteal())
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.steal(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "target is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 100, noInventory);
			wizard.steal(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard steal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);

			if (wizard1.steal(wizard))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "no inventory wizard steal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);

			if (wizard1.steal(wizard))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid wizard canSteal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 250, noInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			if (wizard1.steal(wizard))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "thief no space steal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 5, noInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);

			if (wizard1.steal(wizard))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.isLootable(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);

			if (wizard.isLootable())
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "alive wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 250, noInventory);
			if (wizard.isLootable())
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.canLoot(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);

			if (wizard.canLoot())
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "alive wizard: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 250, noInventory);
			if (wizard.canLoot())
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.loot(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "looter is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 100, smallInventory);
			wizard.loot(null);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "alive wizard, can't loot: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, smallInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);

			if (wizard.loot(wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "dead wizard no loot: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 25, noInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 200, noInventory);

			if (wizard.loot(wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid loot no space: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 0, noInventory);

			if (wizard.loot(wizard1))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid loot: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			Wizard wizard1 = new Wizard("W", masterLevel, 100, 10, 1000, 1000, 1000, basicSpells, basicProtection, 200, noInventory);

			if (wizard.loot(wizard1))
				if (wizard1.possesses(basicMPPotion) || wizard1.possesses(basicHPPotion))
					pass();
				else
					fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.takeDamage(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "take negative damage: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.takeDamage(-90);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid take damage: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.takeDamage(90);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 10/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.takeDamage(5);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 5/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "invalid take damage: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.takeDamage(110);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 0/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.takeDamagePercent(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of upper bounds % damage: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.takeDamagePercent(1000);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of lower bounds % damage: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.takeDamagePercent(-1000);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid take % damage: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.takeDamagePercent(60);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 40/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.takeDamagePercent(40);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 0/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "overkill take % damage: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 50, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 50/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.takeDamagePercent(100);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 0/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.weakenMagic(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "weaken negative magic: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.weakenMagic(-100);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid weaken magic: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.weakenMagic(100);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 900/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.weakenMagic(800);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 100/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "invalid weaken magic: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.weakenMagic(1100);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 0/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.weakenMagicPercent(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of upper bounds weaken % mana: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.weakenMagicPercent(500);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of lower bounds weaken % mana: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.weakenMagicPercent(-500);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "valid weaken % mana: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.weakenMagicPercent(50);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 500/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.weakenMagicPercent(20);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 300/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "overkill weaken % magic: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 500, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 500/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.weakenMagicPercent(100);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 0/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.heal(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "negative heal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.heal(-5);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "heal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 0/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.heal(5);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 5/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.heal(20);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 25/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "overheal: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 0/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.heal(500);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			// soll laut moodle tatsaechlich so funktionieren
			if (wizard.toString().equals("[W(*****): 500/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.healPercent(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of upper bounds heal %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.healPercent(500);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of lower bounds heal %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			wizard.healPercent(-500);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "heal %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 0, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 0/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.healPercent(50);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 50/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.healPercent(20);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 70/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "overheal %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 50, 1000, 1000, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 50/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.healPercent(100);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			// soll laut moodle tatsaechlich so funktionieren
			if (wizard.toString().equals("[W(*****): 150/100 1000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.enforceMagic(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "enforce negative magic: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 0, 1000, noSpells, noProtection, 25, noInventory);
			wizard.enforceMagic(-500);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "enforce magic: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 0, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 0/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.enforceMagic(500);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 500/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.enforceMagic(200);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 700/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "over enforce magic: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 0, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 0/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.enforceMagic(5000);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 5000/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.enforceMagicPercent(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of upper bounds magic %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 0, 1000, noSpells, noProtection, 25, noInventory);
			wizard.enforceMagicPercent(500);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "out of lower bounds magic %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 0, 1000, noSpells, noProtection, 25, noInventory);
			wizard.enforceMagicPercent(-500);
			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "enforce magic %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 0, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 0/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.enforceMagicPercent(50);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 500/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
			wizard.enforceMagicPercent(10);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (wizard.toString().equals("[W(*****): 100/100 600/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "over enforce magic %: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 500, 1000, noSpells, noProtection, 25, noInventory);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			if (!wizard.toString().equals("[W(*****): 100/100 500/1000; 1000 Knuts; knows []; carries []]"))
				fail();
			wizard.enforceMagicPercent(100);
			System.out.println(ANSI_YELLOW + "wizard" + ANSI_RESET);
			System.out.println(wizard.toString());
			// soll laut moodle tatsaechlich so funktionieren
			if (wizard.toString().equals("[W(*****): 100/100 1500/1000; 1000 Knuts; knows []; carries []]"))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.isProtected(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, noProtection, 25, basicInventory);

			if (wizard.isProtected(null))
				fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "noProtection: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, noProtection, 25, basicInventory);

			if (wizard.isProtected(basicPercAttackMP10))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not protected: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);

			if (wizard.isProtected(simpleSpell))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "protected: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);

			if (wizard.isProtected(basicPercAttackMP10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.setProtection(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, noProtection, 25, basicInventory);
			wizard.setProtection(null);
			fail();

		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not protected: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, noProtection, 25, basicInventory);
			wizard.setProtection(basicProtection);
			if (wizard.isProtected(simpleSpell))
				fail();
			else
				pass();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "protected: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, noProtection, 25, basicInventory);
			wizard.setProtection(basicProtection);
			if (wizard.isProtected(basicPercAttackMP10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(ANSI_CYAN + "Test Wizard.removeProtection(): " + ANSI_RESET);
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "is null: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			wizard.removeProtection(null);

			fail();
		}
		catch (IllegalArgumentException e)
		{
			pass();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not fully removed: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			wizard.removeProtection(simpleProtection);
			if (wizard.isProtected(basicPercAttackHP10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "not fully removed: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			wizard.removeProtection(simpleProtection);
			if (wizard.isProtected(basicPercAttackHP10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// =======================================================================================================================================
		System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber() + ": " + "all removed: ");
		try
		{
			Wizard wizard = new Wizard("W", masterLevel, 100, 100, 1000, 1000, 1000, basicSpells, basicProtection, 25, basicInventory);
			wizard.setProtection(basicProtection);
			if (wizard.isProtected(basicPercAttackHP10))
				pass();
			else
				fail();
		}
		catch (IllegalArgumentException e)
		{
			throwing();
		}
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (validTest)
			System.out.println(ANSI_GREEN + " \n \t [TEST PASSED] \n" + ANSI_RESET);
		else
			System.out.println(ANSI_RED + "\n \t [TEST FAILED] \n" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
		if (totalTest)
			System.out.println("\u001B[42m" + "\t [ALL TESTS PASSED]" + ANSI_RESET);
		else
			System.out.println("\u001B[41m" + "\t [ONE/MORE TESTS FAILED]" + ANSI_RESET);
		validTest = true;
		// #######################################################################################################################################
	}
}
