/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "fic.h"

static int cpt = 0;

int *
mulpar2_1_svc(int *argp, struct svc_req *rqstp){
  static int  result;
  result=(*argp)*2;
  /*
   * insert server code here
   */

  return &result;
}

void *
affichamp_1_svc(struct toto *argp, struct svc_req *rqstp){
  static char * result;

  printf("%d %c\n",(*argp).c1,(*argp).c2);
	
  /*
   * insert server code here
   */

  return (void *) &result;
}

char **
concat_1_svc(struct bichaine *argp, struct svc_req *rqstp){
  static char * result;

  result=(*argp).s1;
  strcat(result,(*argp).s2);
  
  /*
   * insert server code here
   */

  return &result;
}

void *
plusun_1_svc(void *argp, struct svc_req *rqstp){
  static char * result;

  printf("%d\n",cpt++);
  
  /*
   * insert server code here
   */

  return (void *) &result;
}
