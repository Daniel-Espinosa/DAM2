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
        
        if(paleta)
        {
            Input.GetAxisRaw("Vertical");
        }else
        {
            Input.GetAxisRaw("Vertical");
        }


    }
}
