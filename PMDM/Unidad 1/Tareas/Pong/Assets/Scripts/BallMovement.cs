using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class BallMovement : MonoBehaviour
{
    [SerializeField]
    private float velocity = 1.0f;

    private float maxVelocity = 10.0f;

    [SerializeField]
    private Rigidbody2D ballBody;
    // Start is called before the first frame update



    [SerializeField]
    private GameManager gameManager;

    private static float collisionPaleta = 1f;

    public static float CollisionPaleta { get => collisionPaleta; set => collisionPaleta = value; }




    void Start()
    {
     ballBody = GetComponent<Rigidbody2D>();
        launch();    
    }


    



    public void launch()
    {

        float xVelocity;
        float yVelocity;

        if (Random.Range(0, 2) == 0)
        {
            xVelocity = 1;
        }
        else
        {
            xVelocity = -1;
        }


        if (Random.Range(0, 2) == 0)
        {
            yVelocity = 1;
        }
        else
        {
            yVelocity = -1;
        }

        ballBody.velocity=new Vector2(xVelocity, yVelocity)*velocity;  

    }

    // Update is called once per frame
    void Update()
    {
        
    }


    //Triger

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.gameObject.tag == "GolA") {
            gameManager.scoredGoalA();

        } else if (collision.gameObject.tag == "GolB")
        {
            gameManager.scoredGoalB();
        }
    }



    //Colision en paleta
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "PalaA" || collision.gameObject.tag == "PalaB" ) {

            collisionPaleta += 0.02f;
            ballBody.velocity *= collisionPaleta;
            /*
            if(ballBody.velocity > maxVelocity)
            {
                ballBody.velocity = maxVelocity;
            }
            */
        }
    }


}
