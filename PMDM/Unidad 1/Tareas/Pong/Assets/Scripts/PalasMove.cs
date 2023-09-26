using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PalasMove : MonoBehaviour
{
    [SerializeField]
    private float velocity = 7f;


    [SerializeField]
    private bool paleta = false;

    private float yLimit = 2.7f;


    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        float movement;
        
        if(paleta)
        {
            movement = Input.GetAxisRaw("Vertical");
        }else
        {
            movement = Input.GetAxisRaw("Vertical2");
        }


        //transform.position += new Vector3 (0f, movement * velocity*Time.deltaTime, 0f);

        /*
        Vector2 paddlePosition = transform.position;
        paddlePosition.y = Math.Clamp(paddlePosition.y + movement * velocity * Time.deltaTime, -yLimit, yLimit);
        transform.position = paddlePosition;
        */


        
        Vector2 paddlePosition = transform.position;
        paddlePosition.y = Math.Clamp(paddlePosition.y + movement * velocity* Time.deltaTime * BallMovement.CollisionPaleta, -yLimit, yLimit);
        transform.position = paddlePosition;
        



    }
}
