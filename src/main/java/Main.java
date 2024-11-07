import entity.Film;
import entity.Planet;
import entity.Character;
import jakarta.persistence.Query;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            selectAllPlanets(entityManager);
            selectEpisodes789(entityManager);
            selectJediOrder(entityManager);
            selectCharactersDead(entityManager);
            selectPlanetsBy2Diameters(entityManager, 0, 10000);
            select3Charas(entityManager);
            selectAllDeaths(entityManager);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void selectAllPlanets(EntityManager entityManager) {
            Query planets = entityManager.createNativeQuery("SELECT * FROM planets", Planet.class);
            List<Planet> planetList = planets.getResultList();
        System.out.println("**************************************************** ALL PLANETS ****************************************************");
            for (Planet planet : planetList) {
                System.out.println(planet);
            }

    }

    public static void selectEpisodes789(EntityManager entityManager) {
        String[] episodios = {"VII", "VIII", "IX"};
        System.out.println("**************************************************** EPISODES VII,VIII,IX ****************************************************");
        for (String episodio : episodios) {
            TypedQuery<Film> filmByEpisode = entityManager.createNamedQuery("Film.byEpisode", Film.class);
            filmByEpisode.setParameter(1, episodio);
            Film film = filmByEpisode.getSingleResult();
            System.out.println("******************************** EPISODE " + episodio + " ********************************");
            System.out.println(film);
        }
    }

    public static void selectJediOrder(EntityManager entityManager) {
        TypedQuery<Character> characterByOrder = entityManager.createNamedQuery("Character.byAffiliation", Character.class);
        characterByOrder.setParameter(1, "Jedi Order");
        List<Character> characterList = characterByOrder.getResultList();
        System.out.println("**************************************************** CHARACTER BY Jedi Order ****************************************************");
        for (Character character : characterList) {
            System.out.println("****************************************************");
            System.out.println(character);
            System.out.println("****************************************************");
        }
    }

    public static void selectCharactersDead(EntityManager entityManager) {
        List<Object[]> results = entityManager.createNativeQuery("SELECT c.name AS dead_character_name, k.name AS killer_name FROM characters c INNER JOIN deaths d ON c.id = d.id LEFT JOIN characters k ON d.id = k.id WHERE d.id_film = 3").getResultList();

        System.out.println("**************************************************** CHARACTER KILLED IN EPISODE III ****************************************************");
        for (Object[] characters : results) {
            String dead_character_name = characters[0].toString();
            String killer_name = characters[1].toString();
            System.out.println("****************************************************");
            System.out.println(dead_character_name + " killed by: " + killer_name);
            System.out.println("****************************************************");

        }
    }

    public static void selectPlanetsBy2Diameters(EntityManager entityManager, int diameter1, int diameter2) {
        TypedQuery<Planet> planetsTypedQuery = entityManager.createNamedQuery("Planets.by2Diameters", Planet.class);
        planetsTypedQuery.setParameter(1, diameter1);
        planetsTypedQuery.setParameter(2, diameter2);
        List<Planet> planetList = planetsTypedQuery.getResultList();
        System.out.println("**************************************************** PLANETS BETWEEN " + diameter1 + "-" + diameter2 + " ****************************************************");
        for (Planet planet : planetList) {
            System.out.println("****************************************************");
            System.out.println(planet);
            System.out.println("****************************************************");
        }

    }

    public static void select3Charas(EntityManager entityManager) {
        Query characters3 = entityManager.createNativeQuery("SELECT * FROM characters c WHERE c.name ='Rey' OR c.name = 'Finn' OR c.name = 'Kylo'", Character.class);
        List<Character> characterList = characters3.getResultList();
        System.out.println("**************************************************** 3 CHARACTERS ****************************************************");
        for (Character character : characterList) {
            System.out.println("****************************************************");
            System.out.println(character);
            System.out.println("****************************************************");
        }
    }

    public static void selectAllDeaths(EntityManager entityManager) {
        System.out.println("**************************************************** ALL DEATHS ****************************************************");

        for (int i = 1; i < 10; i++) {
            System.out.println("***************************************** DEATHS IN EPISODE " + i + " ******************************************");

            Film film = entityManager.find(Film.class, i);
            if (film == null) {
                System.out.println("No film found for episode " + i);
                return;
            }
            Query typedQuery = entityManager.createNamedQuery("Deaths.byEpisode");
            typedQuery.setParameter("episode", film);
            List<Object[]> characterList = typedQuery.getResultList();
            for (Object[] characters : characterList) {
                String dead_character_name = characters[0].toString();
                String killer_name = characters[1].toString();
                System.out.println("****************************************************");
                System.out.println(dead_character_name + " killed by: " + killer_name);
                System.out.println("****************************************************");
            }
        }
    }

}
