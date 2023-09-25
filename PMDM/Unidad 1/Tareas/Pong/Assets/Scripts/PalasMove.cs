using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PalasMove : MonoBehaviour
{
    [SerializeField]
    private float velocity = 7f;


    [SerializeField]
    private bool paleta = false;


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


        transform.position += new Vector3 (0f, movement * velocity*Time.deltaTime, 0f);

           

    }
}
