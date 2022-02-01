import pandas as pd
import numpy as np
import pickle
import joblib

# Verinin Okunması #s
column = ['cümle']
df = pd.read_csv('manset.csv',encoding = 'utf-8',sep = '"')
df.columns = column
df.info()
#Veri setindeki Türkçe ek kelimelerinin kaldırılması
def remove_stopwords(df_fon):
    stopwords = open('turkce-stop-words','r').read().split()
    df_fon['stopwords_removed'] = list(map(lambda doc:
        [word for word in doc if word not in stopwords],df_fon['cümle']))

remove_stopwords(df)

# 1 Ekonomi 2 Sağlık
df['Manset'] = 1
df.Manset.iloc[69:129] = 2
df.Manset.iloc[129:143] = 3
df.Manset.iloc[143:155] = 4
from sklearn.model_selection import train_test_split
X_train,X_test,Y_train,Y_test = train_test_split(df['cümle'],df['Manset'],test_size = 0.3,random_state = 0)

from sklearn.feature_extraction.text import CountVectorizer
vect = CountVectorizer(encoding ='iso-8859-9').fit(X_train)
X_train_vectorizer = vect.transform(X_train)
joblib.dump(vect, 'manset.pkl')

from sklearn.linear_model import LogisticRegression
regressor = LogisticRegression()
regressor.fit(X_train_vectorizer , Y_train)

pickle.dump(regressor, open('model3.pkl', 'wb'))

