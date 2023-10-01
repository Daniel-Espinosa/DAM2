using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MenuInicioManager : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void botonIniciar()
    {
        SceneManager.LoadScene("Juego");
        //Debug.Log("start");
    }

    public void botonExit()
    {
        Application.Quit();
        //Debug.Log("exit");
    }

}
