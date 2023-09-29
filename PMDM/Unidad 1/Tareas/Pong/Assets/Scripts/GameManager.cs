using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class GameManager : MonoBehaviour
{

    private int scoreA = 0 , scoreB = 0;

    [SerializeField]
    private GameObject Ball;

    [SerializeField]
    private TMP_Text ScoreA, ScoreB;

    //patron singelton para solo tener un GameManager
    public static GameManager Instance;

    private void Awake()
    {
        // Comprueba si la instancia ya existe
        if (Instance == null)
        {
            // Si no, establece la instancia a esta
            Instance = this;
        }
        // Si la instancia ya existe y no es esta:
        else if (Instance != this)
        {
            // Entonces destruye este objeto. Esto refuerza nuestro patrón Singleton, lo que significa que solo puede haber una instancia de un GameManager.
            Destroy(gameObject);
        }
        // Establece este para no ser destruido cuando se recargue la escena
        DontDestroyOnLoad(gameObject);
    }


    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    IEnumerator waitOneSec()
    {
        Ball.GetComponent<Transform>().SetPositionAndRotation(new Vector3(0, 0, 0), transform.rotation);
        Ball.GetComponent<Rigidbody2D>().velocity = Vector3.zero;
        yield return new WaitForSeconds(1);
        Ball.GetComponent<BallMovement>().launch();
    }

    public void scoredGoalA()
    {
        scoreA += 1;
        ScoreA.SetText( scoreA.ToString());
        StartCoroutine(waitOneSec());   
    }

    public void scoredGoalB()
    {
        scoreB += 1;
        ScoreB.SetText( scoreB.ToString());
        StartCoroutine (waitOneSec());
    }




}
