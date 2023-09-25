using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallMovement : MonoBehaviour
{
    [SerializeField]
    private float velocity = 1.0f;
    [SerializeField]
    private Rigidbody2D ballBody;
    // Start is called before the first frame update
    void Start()
    {
     ballBody = GetComponent<Rigidbody2D>();
        launch();
        
    }

    void launch()
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
}
