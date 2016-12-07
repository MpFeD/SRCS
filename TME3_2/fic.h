/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _FIC_H_RPCGEN
#define _FIC_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct toto {
	int c1;
	char c2;
};
typedef struct toto toto;

struct bichaine {
	char s1[32];
	char s2[32];
};
typedef struct bichaine bichaine;

#define FIC 0x21234567
#define v1 1

#if defined(__STDC__) || defined(__cplusplus)
#define mulpar2 1
extern  int * mulpar2_1(int *, CLIENT *);
extern  int * mulpar2_1_svc(int *, struct svc_req *);
#define affichamp 2
extern  void * affichamp_1(struct toto *, CLIENT *);
extern  void * affichamp_1_svc(struct toto *, struct svc_req *);
#define concat 3
extern  char ** concat_1(struct bichaine *, CLIENT *);
extern  char ** concat_1_svc(struct bichaine *, struct svc_req *);
#define plusun 4
extern  void * plusun_1(void *, CLIENT *);
extern  void * plusun_1_svc(void *, struct svc_req *);
extern int fic_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define mulpar2 1
extern  int * mulpar2_1();
extern  int * mulpar2_1_svc();
#define affichamp 2
extern  void * affichamp_1();
extern  void * affichamp_1_svc();
#define concat 3
extern  char ** concat_1();
extern  char ** concat_1_svc();
#define plusun 4
extern  void * plusun_1();
extern  void * plusun_1_svc();
extern int fic_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_toto (XDR *, toto*);
extern  bool_t xdr_bichaine (XDR *, bichaine*);

#else /* K&R C */
extern bool_t xdr_toto ();
extern bool_t xdr_bichaine ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_FIC_H_RPCGEN */
