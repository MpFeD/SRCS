struct toto{
       int c1;
       char c2;
};

struct bichaine{
       char s1[32];
       char s2[32];
};

program FIC{
	version v1{
		int mulpar2(int)=1;
		void affichamp(struct toto)=2;
		string concat(struct bichaine)=3;
		void plusun()=4;
	}=1;
}=0x21234567;
